package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.PmsProductCategory;

public interface PmsProductCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductCategory record);

    PmsProductCategory selectByPrimaryKey(Long id);

    List<PmsProductCategory> selectAll();

    int updateByPrimaryKey(PmsProductCategory record);
}