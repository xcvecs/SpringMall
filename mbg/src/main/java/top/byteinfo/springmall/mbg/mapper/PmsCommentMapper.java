package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.PmsComment;

public interface PmsCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsComment record);

    PmsComment selectByPrimaryKey(Long id);

    List<PmsComment> selectAll();

    int updateByPrimaryKey(PmsComment record);
}