package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.CmsHelpCategory;

public interface CmsHelpCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsHelpCategory record);

    CmsHelpCategory selectByPrimaryKey(Long id);

    List<CmsHelpCategory> selectAll();

    int updateByPrimaryKey(CmsHelpCategory record);
}