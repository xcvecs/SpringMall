package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsAdminPermissionRelation;

public interface UmsAdminPermissionRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsAdminPermissionRelation record);

    UmsAdminPermissionRelation selectByPrimaryKey(Long id);

    List<UmsAdminPermissionRelation> selectAll();

    int updateByPrimaryKey(UmsAdminPermissionRelation record);
}