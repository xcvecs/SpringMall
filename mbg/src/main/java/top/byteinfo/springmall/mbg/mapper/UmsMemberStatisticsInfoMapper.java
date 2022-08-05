package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsMemberStatisticsInfo;

public interface UmsMemberStatisticsInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberStatisticsInfo record);

    UmsMemberStatisticsInfo selectByPrimaryKey(Long id);

    List<UmsMemberStatisticsInfo> selectAll();

    int updateByPrimaryKey(UmsMemberStatisticsInfo record);
}