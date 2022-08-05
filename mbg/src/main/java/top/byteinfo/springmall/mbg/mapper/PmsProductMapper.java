package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.PmsProduct;

public interface PmsProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProduct record);

    PmsProduct selectByPrimaryKey(Long id);

    List<PmsProduct> selectAll();

    int updateByPrimaryKey(PmsProduct record);
}