package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsMemberTag;

public interface UmsMemberTagMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberTag record);

    UmsMemberTag selectByPrimaryKey(Long id);

    List<UmsMemberTag> selectAll();

    int updateByPrimaryKey(UmsMemberTag record);
}