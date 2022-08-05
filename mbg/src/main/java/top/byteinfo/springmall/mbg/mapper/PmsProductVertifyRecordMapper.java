package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.PmsProductVertifyRecord;

public interface PmsProductVertifyRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductVertifyRecord record);

    PmsProductVertifyRecord selectByPrimaryKey(Long id);

    List<PmsProductVertifyRecord> selectAll();

    int updateByPrimaryKey(PmsProductVertifyRecord record);
}