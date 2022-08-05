package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsRoleResourceRelation;

public interface UmsRoleResourceRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsRoleResourceRelation record);

    UmsRoleResourceRelation selectByPrimaryKey(Long id);

    List<UmsRoleResourceRelation> selectAll();

    int updateByPrimaryKey(UmsRoleResourceRelation record);
}