package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.CmsSubject;

public interface CmsSubjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsSubject record);

    CmsSubject selectByPrimaryKey(Long id);

    List<CmsSubject> selectAll();

    int updateByPrimaryKey(CmsSubject record);
}