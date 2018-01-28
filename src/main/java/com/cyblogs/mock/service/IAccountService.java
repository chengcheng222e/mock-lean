package com.cyblogs.mock.service;


import com.cyblogs.mock.domain.Account;
import com.cyblogs.mock.domain.School;

/**
 * Created with IntelliJ IDEA
 * <p>
 * User: chenyuan
 */
public interface IAccountService {

    int add(Account account, School school);

    int add(Account account);

}
