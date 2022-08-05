package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.CmsSubjectCategory;

public interface CmsSubjectCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsSubjectCategory record);

    CmsSubjectCategory selectByPrimaryKey(Long id);

    List<CmsSubjectCategory> selectAll();

    int updateByPrimaryKey(CmsSubjectCategory record);
}