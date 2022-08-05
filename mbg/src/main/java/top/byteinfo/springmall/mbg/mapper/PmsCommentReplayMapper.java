package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.PmsCommentReplay;

public interface PmsCommentReplayMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsCommentReplay record);

    PmsCommentReplay selectByPrimaryKey(Long id);

    List<PmsCommentReplay> selectAll();

    int updateByPrimaryKey(PmsCommentReplay record);
}