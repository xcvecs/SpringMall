package com.example.sqltest.mbg.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TbArticle1 {
    private Integer id;

    private Integer userId;

    private Integer categoryId;

    private String articleCover;

    private String articleTitle;

    private Boolean type;

    private String originalUrl;

    private Boolean isTop;

    private Boolean isDelete;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

    private String articleContent;
}