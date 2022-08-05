package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsMemberReceiveAddress;

public interface UmsMemberReceiveAddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberReceiveAddress record);

    UmsMemberReceiveAddress selectByPrimaryKey(Long id);

    List<UmsMemberReceiveAddress> selectAll();

    int updateByPrimaryKey(UmsMemberReceiveAddress record);
}