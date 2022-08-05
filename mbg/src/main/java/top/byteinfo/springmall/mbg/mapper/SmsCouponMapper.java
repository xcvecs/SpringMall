package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.SmsCoupon;

public interface SmsCouponMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsCoupon record);

    SmsCoupon selectByPrimaryKey(Long id);

    List<SmsCoupon> selectAll();

    int updateByPrimaryKey(SmsCoupon record);
}