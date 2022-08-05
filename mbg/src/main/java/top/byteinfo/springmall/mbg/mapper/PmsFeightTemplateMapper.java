package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.PmsFeightTemplate;

public interface PmsFeightTemplateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsFeightTemplate record);

    PmsFeightTemplate selectByPrimaryKey(Long id);

    List<PmsFeightTemplate> selectAll();

    int updateByPrimaryKey(PmsFeightTemplate record);
}