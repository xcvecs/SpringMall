package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.PmsProductAttributeCategory;

public interface PmsProductAttributeCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductAttributeCategory record);

    PmsProductAttributeCategory selectByPrimaryKey(Long id);

    List<PmsProductAttributeCategory> selectAll();

    int updateByPrimaryKey(PmsProductAttributeCategory record);
}