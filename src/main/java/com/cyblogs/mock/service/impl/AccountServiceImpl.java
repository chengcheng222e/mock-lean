package com.cyblogs.mock.service.impl;

import com.cyblogs.mock.dao.IAccountDAO;
import com.cyblogs.mock.domain.Account;
import com.cyblogs.mock.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 * <p>
 * User: chenyuan
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDAO accountDAO;

    @Override
    public int add(Account account) {
        return accountDAO.add(account);
    }


}
