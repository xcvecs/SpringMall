package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.PmsProductOperateLog;

public interface PmsProductOperateLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductOperateLog record);

    PmsProductOperateLog selectByPrimaryKey(Long id);

    List<PmsProductOperateLog> selectAll();

    int updateByPrimaryKey(PmsProductOperateLog record);
}