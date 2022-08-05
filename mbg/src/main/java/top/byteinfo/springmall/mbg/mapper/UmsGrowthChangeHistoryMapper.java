package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsGrowthChangeHistory;

public interface UmsGrowthChangeHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsGrowthChangeHistory record);

    UmsGrowthChangeHistory selectByPrimaryKey(Long id);

    List<UmsGrowthChangeHistory> selectAll();

    int updateByPrimaryKey(UmsGrowthChangeHistory record);
}