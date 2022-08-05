package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.PmsProductLadder;

public interface PmsProductLadderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductLadder record);

    PmsProductLadder selectByPrimaryKey(Long id);

    List<PmsProductLadder> selectAll();

    int updateByPrimaryKey(PmsProductLadder record);
}