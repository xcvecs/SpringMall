package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.OmsOrderOperateHistory;

public interface OmsOrderOperateHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderOperateHistory record);

    OmsOrderOperateHistory selectByPrimaryKey(Long id);

    List<OmsOrderOperateHistory> selectAll();

    int updateByPrimaryKey(OmsOrderOperateHistory record);
}