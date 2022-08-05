package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.CmsTopicCategory;

public interface CmsTopicCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsTopicCategory record);

    CmsTopicCategory selectByPrimaryKey(Long id);

    List<CmsTopicCategory> selectAll();

    int updateByPrimaryKey(CmsTopicCategory record);
}