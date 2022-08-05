package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.CmsPrefrenceArea;

public interface CmsPrefrenceAreaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsPrefrenceArea record);

    CmsPrefrenceArea selectByPrimaryKey(Long id);

    List<CmsPrefrenceArea> selectAll();

    int updateByPrimaryKey(CmsPrefrenceArea record);
}