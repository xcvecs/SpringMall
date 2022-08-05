package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.SmsCouponProductRelation;

public interface SmsCouponProductRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsCouponProductRelation record);

    SmsCouponProductRelation selectByPrimaryKey(Long id);

    List<SmsCouponProductRelation> selectAll();

    int updateByPrimaryKey(SmsCouponProductRelation record);
}