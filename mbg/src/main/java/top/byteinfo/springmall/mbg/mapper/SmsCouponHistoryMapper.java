package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.SmsCouponHistory;

public interface SmsCouponHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsCouponHistory record);

    SmsCouponHistory selectByPrimaryKey(Long id);

    List<SmsCouponHistory> selectAll();

    int updateByPrimaryKey(SmsCouponHistory record);
}