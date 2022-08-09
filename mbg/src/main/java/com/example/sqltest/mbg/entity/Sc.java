package com.example.sqltest.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sc {
    private String sid;

    private String cid;

//    private BigDecimal score;
    private Integer score;
}