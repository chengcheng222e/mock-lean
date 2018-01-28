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
public class School {

    private Long id;
    private String name;
    private String address;

    public School() {
    }

    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
