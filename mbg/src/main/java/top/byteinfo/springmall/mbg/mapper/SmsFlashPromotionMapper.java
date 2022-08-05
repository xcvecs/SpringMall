package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.SmsFlashPromotion;

public interface SmsFlashPromotionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsFlashPromotion record);

    SmsFlashPromotion selectByPrimaryKey(Long id);

    List<SmsFlashPromotion> selectAll();

    int updateByPrimaryKey(SmsFlashPromotion record);
}