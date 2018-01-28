package com.cyblogs.mock.service.impl;

import com.alibaba.fastjson.JSON;
import com.cyblogs.mock.domain.School;
import com.cyblogs.mock.service.ISchoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 * <p>
 * User: chenyuan
 */
@Slf4j
@Service
public class SchoolServiceImpl implements ISchoolService {

    @Override
    public int add(School school) {
        log.info("SchoolServiceImpl ===> add, school={}", JSON.toJSONString(school));
        return 0;
    }
}
