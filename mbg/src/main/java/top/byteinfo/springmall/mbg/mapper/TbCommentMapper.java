package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.TbComment;

public interface TbCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbComment record);

    TbComment selectByPrimaryKey(Integer id);

    List<TbComment> selectAll();

    int updateByPrimaryKey(TbComment record);
}