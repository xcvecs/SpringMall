package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.OmsOrder;

public interface OmsOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OmsOrder record);

    OmsOrder selectByPrimaryKey(Long id);

    List<OmsOrder> selectAll();

    int updateByPrimaryKey(OmsOrder record);
}