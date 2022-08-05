package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsMemberMemberTagRelation;

public interface UmsMemberMemberTagRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberMemberTagRelation record);

    UmsMemberMemberTagRelation selectByPrimaryKey(Long id);

    List<UmsMemberMemberTagRelation> selectAll();

    int updateByPrimaryKey(UmsMemberMemberTagRelation record);
}