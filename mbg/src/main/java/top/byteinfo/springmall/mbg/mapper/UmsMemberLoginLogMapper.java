package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsMemberLoginLog;

public interface UmsMemberLoginLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberLoginLog record);

    UmsMemberLoginLog selectByPrimaryKey(Long id);

    List<UmsMemberLoginLog> selectAll();

    int updateByPrimaryKey(UmsMemberLoginLog record);
}