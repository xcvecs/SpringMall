package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.SmsHomeRecommendSubject;

public interface SmsHomeRecommendSubjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeRecommendSubject record);

    SmsHomeRecommendSubject selectByPrimaryKey(Long id);

    List<SmsHomeRecommendSubject> selectAll();

    int updateByPrimaryKey(SmsHomeRecommendSubject record);
}