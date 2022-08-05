package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.PmsProductCategoryAttributeRelation;

public interface PmsProductCategoryAttributeRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductCategoryAttributeRelation record);

    PmsProductCategoryAttributeRelation selectByPrimaryKey(Long id);

    List<PmsProductCategoryAttributeRelation> selectAll();

    int updateByPrimaryKey(PmsProductCategoryAttributeRelation record);
}