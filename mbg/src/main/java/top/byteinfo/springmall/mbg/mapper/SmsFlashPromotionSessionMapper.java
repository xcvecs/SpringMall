package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.SmsFlashPromotionSession;

public interface SmsFlashPromotionSessionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsFlashPromotionSession record);

    SmsFlashPromotionSession selectByPrimaryKey(Long id);

    List<SmsFlashPromotionSession> selectAll();

    int updateByPrimaryKey(SmsFlashPromotionSession record);
}