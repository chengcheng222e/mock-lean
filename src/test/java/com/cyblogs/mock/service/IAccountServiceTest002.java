package com.cyblogs.mock.service;

import com.cyblogs.mock.domain.Account;
import com.cyblogs.mock.domain.School;
import com.cyblogs.mock.service.impl.AccountServiceImpl;
import com.cyblogs.mock.uitl.MockerUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@RunWith(PowerMockRunner.class)
@SpringBootTest
public class IAccountServiceTest002 {

    @Test
    public void add_001() {
        MockerUtil<AccountServiceImpl> mocker = new MockerUtil<AccountServiceImpl>(AccountServiceImpl.class);
        Account account = new Account("testcase", 99.99);
        School school = new School("中南大学", "湖南长沙");
        mocker.tar().add(account, school);
    }

    @Test
    public void add_002() throws Exception {
        MockerUtil<AccountServiceImpl> mocker = new MockerUtil<AccountServiceImpl>(AccountServiceImpl.class);
        Account account = new Account("testcase", 99.99);
        School school = new School("中南大学", "湖南长沙");

        PowerMockito.when(mocker.tar().check()).thenReturn(Boolean.FALSE);
        mocker.tar().add(account, school);
    }
}