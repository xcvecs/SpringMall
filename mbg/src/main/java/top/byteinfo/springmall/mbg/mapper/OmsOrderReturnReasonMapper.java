package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.OmsOrderReturnReason;

public interface OmsOrderReturnReasonMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderReturnReason record);

    OmsOrderReturnReason selectByPrimaryKey(Long id);

    List<OmsOrderReturnReason> selectAll();

    int updateByPrimaryKey(OmsOrderReturnReason record);
}