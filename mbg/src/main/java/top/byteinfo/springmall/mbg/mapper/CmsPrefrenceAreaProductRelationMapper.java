package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.CmsPrefrenceAreaProductRelation;

public interface CmsPrefrenceAreaProductRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsPrefrenceAreaProductRelation record);

    CmsPrefrenceAreaProductRelation selectByPrimaryKey(Long id);

    List<CmsPrefrenceAreaProductRelation> selectAll();

    int updateByPrimaryKey(CmsPrefrenceAreaProductRelation record);
}