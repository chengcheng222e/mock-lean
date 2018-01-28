package com.cyblogs.mock.service.impl;

import com.cyblogs.mock.constant.Constants;
import com.cyblogs.mock.dao.IAccountDAO;
import com.cyblogs.mock.dao.ISchoolDAO;
import com.cyblogs.mock.domain.Account;
import com.cyblogs.mock.domain.School;
import com.cyblogs.mock.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA
 * <p>
 * User: chenyuan
 */
@Slf4j
@Service
public class AccountServiceImpl implements IAccountService {

    @Resource
    private IAccountDAO accountDAO;
    @Resource
    private ISchoolDAO schoolDAO;

    @Override
    public int add(Account account, School school) {
        boolean checkResult = check();
        int count = 0;
        if (checkResult) {
            accountDAO.add(account);
            schoolDAO.add(school);
            count++;
        } else {
            log.info("Exception error. 异常分支。");
        }
        if (count > 0) {
            finish();
        }
        return Constants.OK;
    }

    private void finish() {
        log.info("AccountServiceImpl ===> finish, #############");
    }

    public boolean check() {
        log.info("AccountServiceImpl ===> check, #############");
        return Boolean.TRUE;
    }

    @Override
    public int add(Account account) {
        accountDAO.add(account);
        return Constants.OK;
    }
}
