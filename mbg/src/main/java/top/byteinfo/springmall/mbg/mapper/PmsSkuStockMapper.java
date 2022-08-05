package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.PmsSkuStock;

public interface PmsSkuStockMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsSkuStock record);

    PmsSkuStock selectByPrimaryKey(Long id);

    List<PmsSkuStock> selectAll();

    int updateByPrimaryKey(PmsSkuStock record);
}