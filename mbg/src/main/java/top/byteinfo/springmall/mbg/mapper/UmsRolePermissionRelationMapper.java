package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsRolePermissionRelation;

public interface UmsRolePermissionRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsRolePermissionRelation record);

    UmsRolePermissionRelation selectByPrimaryKey(Long id);

    List<UmsRolePermissionRelation> selectAll();

    int updateByPrimaryKey(UmsRolePermissionRelation record);
}