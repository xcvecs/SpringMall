package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.SmsFlashPromotionLog;

public interface SmsFlashPromotionLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmsFlashPromotionLog record);

    SmsFlashPromotionLog selectByPrimaryKey(Integer id);

    List<SmsFlashPromotionLog> selectAll();

    int updateByPrimaryKey(SmsFlashPromotionLog record);
}