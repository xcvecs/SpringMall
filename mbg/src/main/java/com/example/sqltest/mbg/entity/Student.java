package com.example.sqltest.mbg.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Student {
    private String sid;

    private String sname;

    private Date sage;

    private String ssex;
}