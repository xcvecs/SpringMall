package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsPermission;

public interface UmsPermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsPermission record);

    UmsPermission selectByPrimaryKey(Long id);

    List<UmsPermission> selectAll();

    int updateByPrimaryKey(UmsPermission record);
}