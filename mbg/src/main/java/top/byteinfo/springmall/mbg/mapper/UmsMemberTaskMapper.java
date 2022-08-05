package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsMemberTask;

public interface UmsMemberTaskMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberTask record);

    UmsMemberTask selectByPrimaryKey(Long id);

    List<UmsMemberTask> selectAll();

    int updateByPrimaryKey(UmsMemberTask record);
}