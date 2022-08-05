package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.OmsOrderReturnApply;

public interface OmsOrderReturnApplyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderReturnApply record);

    OmsOrderReturnApply selectByPrimaryKey(Long id);

    List<OmsOrderReturnApply> selectAll();

    int updateByPrimaryKey(OmsOrderReturnApply record);
}