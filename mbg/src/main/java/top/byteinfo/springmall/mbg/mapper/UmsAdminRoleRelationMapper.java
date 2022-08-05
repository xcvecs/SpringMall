package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsAdminRoleRelation;

public interface UmsAdminRoleRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsAdminRoleRelation record);

    UmsAdminRoleRelation selectByPrimaryKey(Long id);

    List<UmsAdminRoleRelation> selectAll();

    int updateByPrimaryKey(UmsAdminRoleRelation record);
}