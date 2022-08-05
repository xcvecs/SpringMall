package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.PmsProductAttribute;

public interface PmsProductAttributeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductAttribute record);

    PmsProductAttribute selectByPrimaryKey(Long id);

    List<PmsProductAttribute> selectAll();

    int updateByPrimaryKey(PmsProductAttribute record);
}