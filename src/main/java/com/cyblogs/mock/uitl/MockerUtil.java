package com.cyblogs.mock.uitl;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MockerUtil<T> {
    /**
     * 测试目标对象
     */
    private T target;

    /**
     * 目标对象外部依赖
     */
    private final Map<String, Object> replyerMap;

    /**
     * 构造方法参数
     */
    private Object[] constuctorArgs;
    /**
     * 构造方法参数类型
     */
    private Class[] constuctorClasses;

    /**
     * 够造方法
     *
     * @param clazz 测试目标对象
     */
    public MockerUtil(Class<T> clazz) {
        this.replyerMap = new HashMap<String, Object>();
        setSpy(clazz);
    }

    /**
     * 够造方法
     *
     * @param clazz
     * @param constuctorArgs 构造函数参数
     */
    public MockerUtil(Class<T> clazz, Class[] constuctorClasses, Object[] constuctorArgs) {
        if (constuctorClasses != null) {
            this.constuctorClasses = Arrays.copyOf(constuctorClasses, constuctorClasses.length);
        } else {
            this.constuctorClasses = null;
        }
        if (constuctorArgs != null) {
            this.constuctorArgs = Arrays.copyOf(this.constuctorArgs, this.constuctorArgs.length);
        } else {
            this.constuctorArgs = null;
        }
        this.replyerMap = new HashMap<String, Object>();
        this.setSpy(clazz);
    }

    /**
     * 获得依赖
     *
     * @param relyer
     * @return
     */
    public <R> R rely(Class<R> relyer) {
        return (R) replyerMap.get(relyer.getName());
    }

    /**
     * 获得测试目标对象【简写】
     *
     * @return
     */
    public T tar() {
        return target;
    }

    /**
     * 设置Spy
     *
     * @param clazz
     */
    private void setSpy(Class<T> clazz) {
        try {
            T t = getTargetIntance(clazz);

            target = PowerMockito.spy(t);
            for (Field field : clazz.getDeclaredFields()) {
                if (!isRelyer(field)) {
                    continue;
                }
                Class<?> fieldType = field.getType();
                Object relyerObj = Mockito.mock(fieldType);
                ReflectionTestUtils.setField(target, field.getName(), relyerObj);
                replyerMap.put(fieldType.getName(), relyerObj);
            }
        } catch (Exception e) {
            throw new RuntimeException("Mocker测试设置依赖出错");
        }
    }

    private T getTargetIntance(Class<T> clazz) throws Exception {
        T t = null;
        if (null == constuctorArgs) {
            t = clazz.newInstance();
        } else {
            Constructor<T> constructor = clazz.getConstructor(constuctorClasses);
            t = constructor.newInstance(constuctorArgs);
        }

        return t;
    }

    /**
     * 判断是否是依赖，默认支持： （1）成员变量上是否有注解 （2）成员变量是否以 Facade、Mapper或者Service结尾。
     * 如果该规则不满足，可以重载该方法自己实现。
     *
     * @param field
     * @return
     */
    protected boolean isRelyer(Field field) {
        Annotation[] annotations = field.getAnnotations();
        if (null != annotations && annotations.length > 0) {
            return true;
        }
        String name = field.getName();
        if (null == name) {
            return false;
        }
        return name.endsWith("Service") || name.endsWith("Mapper") || name.endsWith("DAO");
    }
}
