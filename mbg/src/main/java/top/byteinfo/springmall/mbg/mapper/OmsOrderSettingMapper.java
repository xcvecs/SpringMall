package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.OmsOrderSetting;

public interface OmsOrderSettingMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderSetting record);

    OmsOrderSetting selectByPrimaryKey(Long id);

    List<OmsOrderSetting> selectAll();

    int updateByPrimaryKey(OmsOrderSetting record);
}