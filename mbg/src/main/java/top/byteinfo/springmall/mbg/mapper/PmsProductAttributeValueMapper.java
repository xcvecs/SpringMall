package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.PmsProductAttributeValue;

public interface PmsProductAttributeValueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductAttributeValue record);

    PmsProductAttributeValue selectByPrimaryKey(Long id);

    List<PmsProductAttributeValue> selectAll();

    int updateByPrimaryKey(PmsProductAttributeValue record);
}