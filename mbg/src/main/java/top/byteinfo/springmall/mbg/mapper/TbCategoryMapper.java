package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.TbCategory;

public interface TbCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCategory record);

    TbCategory selectByPrimaryKey(Integer id);

    List<TbCategory> selectAll();

    int updateByPrimaryKey(TbCategory record);
}