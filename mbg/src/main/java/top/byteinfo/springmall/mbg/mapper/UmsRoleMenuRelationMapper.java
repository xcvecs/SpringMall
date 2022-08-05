package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsRoleMenuRelation;

public interface UmsRoleMenuRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsRoleMenuRelation record);

    UmsRoleMenuRelation selectByPrimaryKey(Long id);

    List<UmsRoleMenuRelation> selectAll();

    int updateByPrimaryKey(UmsRoleMenuRelation record);
}