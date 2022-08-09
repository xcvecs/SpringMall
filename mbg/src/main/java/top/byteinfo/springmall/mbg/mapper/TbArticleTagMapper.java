package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.TbArticleTag;

public interface TbArticleTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbArticleTag record);

    TbArticleTag selectByPrimaryKey(Integer id);

    List<TbArticleTag> selectAll();

    int updateByPrimaryKey(TbArticleTag record);
}