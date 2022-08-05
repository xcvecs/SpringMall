package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.CmsSubjectProductRelation;

public interface CmsSubjectProductRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsSubjectProductRelation record);

    CmsSubjectProductRelation selectByPrimaryKey(Long id);

    List<CmsSubjectProductRelation> selectAll();

    int updateByPrimaryKey(CmsSubjectProductRelation record);
}