package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsMember;

public interface UmsMemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMember record);

    UmsMember selectByPrimaryKey(Long id);

    List<UmsMember> selectAll();

    int updateByPrimaryKey(UmsMember record);
}