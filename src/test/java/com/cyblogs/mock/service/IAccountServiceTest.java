package com.cyblogs.mock.service;

import com.cyblogs.mock.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class IAccountServiceTest {

    @Resource
    private IAccountService accountService;

    @Test
    public void add() {
        try {
            Account account = new Account();
            account.setName("testcase");
            account.setMoney(100.99);
            accountService.add(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}