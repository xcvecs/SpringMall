package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.CmsTopic;

public interface CmsTopicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsTopic record);

    CmsTopic selectByPrimaryKey(Long id);

    List<CmsTopic> selectAll();

    int updateByPrimaryKey(CmsTopic record);
}