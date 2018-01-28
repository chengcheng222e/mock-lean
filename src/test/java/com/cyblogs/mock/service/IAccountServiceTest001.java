package com.cyblogs.mock.service;

import com.cyblogs.mock.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class IAccountServiceTest001 {


    // @Resource
    @MockBean
    private IAccountService accountService;

    /**
     * 从service这里就开始mock
     */
    @Test
    public void add() {
        try {
            Account account = new Account();
            account.setName("testcase");
            account.setMoney(100.99);
            int result = accountService.add(account);
            Assert.assertEquals(0, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}