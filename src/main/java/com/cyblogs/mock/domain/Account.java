package com.cyblogs.mock.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA
 * <p>
 * User: chenyuan
 */
@Getter
@Setter
public class Account {

    private Long id;
    private String name;
    private double money;

    public Account() {
    }

    public Account(String name, double money) {
        this.name = name;
        this.money = money;
    }
}
