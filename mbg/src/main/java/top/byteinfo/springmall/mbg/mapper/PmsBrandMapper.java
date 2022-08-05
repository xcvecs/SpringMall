package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.PmsBrand;

public interface PmsBrandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsBrand record);

    PmsBrand selectByPrimaryKey(Long id);

    List<PmsBrand> selectAll();

    int updateByPrimaryKey(PmsBrand record);
}