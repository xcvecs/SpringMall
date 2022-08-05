package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.SmsCouponProductCategoryRelation;

public interface SmsCouponProductCategoryRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsCouponProductCategoryRelation record);

    SmsCouponProductCategoryRelation selectByPrimaryKey(Long id);

    List<SmsCouponProductCategoryRelation> selectAll();

    int updateByPrimaryKey(SmsCouponProductCategoryRelation record);
}