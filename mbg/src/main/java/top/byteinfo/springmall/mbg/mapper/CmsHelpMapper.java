package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.CmsHelp;

public interface CmsHelpMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsHelp record);

    CmsHelp selectByPrimaryKey(Long id);

    List<CmsHelp> selectAll();

    int updateByPrimaryKey(CmsHelp record);
}