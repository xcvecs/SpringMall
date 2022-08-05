package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.CmsTopicComment;

public interface CmsTopicCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsTopicComment record);

    CmsTopicComment selectByPrimaryKey(Long id);

    List<CmsTopicComment> selectAll();

    int updateByPrimaryKey(CmsTopicComment record);
}