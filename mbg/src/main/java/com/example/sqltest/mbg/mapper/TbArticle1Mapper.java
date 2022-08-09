package com.example.sqltest.mbg.mapper;

import com.example.sqltest.mbg.entity.TbArticle1;
import java.util.List;

public interface TbArticle1Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbArticle1 record);

    TbArticle1 selectByPrimaryKey(Integer id);

    List<TbArticle1> selectAll();

    int updateByPrimaryKey(TbArticle1 record);
}