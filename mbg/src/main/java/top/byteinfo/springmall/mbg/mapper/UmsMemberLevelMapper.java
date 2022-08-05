package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsMemberLevel;

public interface UmsMemberLevelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberLevel record);

    UmsMemberLevel selectByPrimaryKey(Long id);

    List<UmsMemberLevel> selectAll();

    int updateByPrimaryKey(UmsMemberLevel record);
}