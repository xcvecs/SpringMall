package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsIntegrationConsumeSetting;

public interface UmsIntegrationConsumeSettingMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsIntegrationConsumeSetting record);

    UmsIntegrationConsumeSetting selectByPrimaryKey(Long id);

    List<UmsIntegrationConsumeSetting> selectAll();

    int updateByPrimaryKey(UmsIntegrationConsumeSetting record);
}