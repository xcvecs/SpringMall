package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsRole;

public interface UmsRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsRole record);

    UmsRole selectByPrimaryKey(Long id);

    List<UmsRole> selectAll();

    int updateByPrimaryKey(UmsRole record);
}