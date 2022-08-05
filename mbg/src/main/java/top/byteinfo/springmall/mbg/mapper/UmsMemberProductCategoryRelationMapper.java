package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsMemberProductCategoryRelation;

public interface UmsMemberProductCategoryRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberProductCategoryRelation record);

    UmsMemberProductCategoryRelation selectByPrimaryKey(Long id);

    List<UmsMemberProductCategoryRelation> selectAll();

    int updateByPrimaryKey(UmsMemberProductCategoryRelation record);
}