package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.PmsProductFullReduction;

public interface PmsProductFullReductionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductFullReduction record);

    PmsProductFullReduction selectByPrimaryKey(Long id);

    List<PmsProductFullReduction> selectAll();

    int updateByPrimaryKey(PmsProductFullReduction record);
}