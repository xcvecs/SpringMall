package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.OmsOrderItem;

public interface OmsOrderItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderItem record);

    OmsOrderItem selectByPrimaryKey(Long id);

    List<OmsOrderItem> selectAll();

    int updateByPrimaryKey(OmsOrderItem record);
}