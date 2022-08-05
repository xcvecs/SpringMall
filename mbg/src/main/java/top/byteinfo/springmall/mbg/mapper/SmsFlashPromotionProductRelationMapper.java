package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.SmsFlashPromotionProductRelation;

public interface SmsFlashPromotionProductRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsFlashPromotionProductRelation record);

    SmsFlashPromotionProductRelation selectByPrimaryKey(Long id);

    List<SmsFlashPromotionProductRelation> selectAll();

    int updateByPrimaryKey(SmsFlashPromotionProductRelation record);
}