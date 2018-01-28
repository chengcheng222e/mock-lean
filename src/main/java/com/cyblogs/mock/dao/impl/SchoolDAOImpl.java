package com.cyblogs.mock.dao.impl;

import com.alibaba.fastjson.JSON;
import com.cyblogs.mock.constant.Constants;
import com.cyblogs.mock.dao.ISchoolDAO;
import com.cyblogs.mock.domain.School;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA
 * <p>
 * User: chenyuan
 */
@Slf4j
@Repository
public class SchoolDAOImpl implements ISchoolDAO {

    @Override
    public int add(School school) {
        log.info("SchoolDAOImpl ===> add, school={}", JSON.toJSONString(school));
        return Constants.OK;
    }
}
