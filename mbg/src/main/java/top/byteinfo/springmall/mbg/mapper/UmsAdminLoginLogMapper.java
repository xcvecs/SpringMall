package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsAdminLoginLog;

public interface UmsAdminLoginLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsAdminLoginLog record);

    UmsAdminLoginLog selectByPrimaryKey(Long id);

    List<UmsAdminLoginLog> selectAll();

    int updateByPrimaryKey(UmsAdminLoginLog record);
}