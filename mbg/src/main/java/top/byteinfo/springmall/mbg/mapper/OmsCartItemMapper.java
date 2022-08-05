package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.OmsCartItem;

public interface OmsCartItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OmsCartItem record);

    OmsCartItem selectByPrimaryKey(Long id);

    List<OmsCartItem> selectAll();

    int updateByPrimaryKey(OmsCartItem record);
}