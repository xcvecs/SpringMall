package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.CmsSubjectComment;

public interface CmsSubjectCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsSubjectComment record);

    CmsSubjectComment selectByPrimaryKey(Long id);

    List<CmsSubjectComment> selectAll();

    int updateByPrimaryKey(CmsSubjectComment record);
}