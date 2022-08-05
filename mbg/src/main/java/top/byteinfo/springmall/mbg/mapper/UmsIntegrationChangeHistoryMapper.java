package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsIntegrationChangeHistory;

public interface UmsIntegrationChangeHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsIntegrationChangeHistory record);

    UmsIntegrationChangeHistory selectByPrimaryKey(Long id);

    List<UmsIntegrationChangeHistory> selectAll();

    int updateByPrimaryKey(UmsIntegrationChangeHistory record);
}