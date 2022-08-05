package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.PmsMemberPrice;

public interface PmsMemberPriceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsMemberPrice record);

    PmsMemberPrice selectByPrimaryKey(Long id);

    List<PmsMemberPrice> selectAll();

    int updateByPrimaryKey(PmsMemberPrice record);
}