package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.SmsHomeNewProduct;

public interface SmsHomeNewProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeNewProduct record);

    SmsHomeNewProduct selectByPrimaryKey(Long id);

    List<SmsHomeNewProduct> selectAll();

    int updateByPrimaryKey(SmsHomeNewProduct record);
}