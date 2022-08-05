package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.SmsHomeRecommendProduct;

public interface SmsHomeRecommendProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeRecommendProduct record);

    SmsHomeRecommendProduct selectByPrimaryKey(Long id);

    List<SmsHomeRecommendProduct> selectAll();

    int updateByPrimaryKey(SmsHomeRecommendProduct record);
}