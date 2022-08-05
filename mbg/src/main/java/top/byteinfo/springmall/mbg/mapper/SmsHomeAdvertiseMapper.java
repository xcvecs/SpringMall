package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.SmsHomeAdvertise;

public interface SmsHomeAdvertiseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeAdvertise record);

    SmsHomeAdvertise selectByPrimaryKey(Long id);

    List<SmsHomeAdvertise> selectAll();

    int updateByPrimaryKey(SmsHomeAdvertise record);
}