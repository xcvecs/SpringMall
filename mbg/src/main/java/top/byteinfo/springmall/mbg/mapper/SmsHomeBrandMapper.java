package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.SmsHomeBrand;

public interface SmsHomeBrandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeBrand record);

    SmsHomeBrand selectByPrimaryKey(Long id);

    List<SmsHomeBrand> selectAll();

    int updateByPrimaryKey(SmsHomeBrand record);
}