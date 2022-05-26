package com.gxa.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Emp {

    private Integer id;
    private String name;
    private Integer gender;
    private Integer status;
    private Dept dept;
}
