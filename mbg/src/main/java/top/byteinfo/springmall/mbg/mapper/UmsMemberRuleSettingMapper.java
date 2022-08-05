package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsMemberRuleSetting;

public interface UmsMemberRuleSettingMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberRuleSetting record);

    UmsMemberRuleSetting selectByPrimaryKey(Long id);

    List<UmsMemberRuleSetting> selectAll();

    int updateByPrimaryKey(UmsMemberRuleSetting record);
}