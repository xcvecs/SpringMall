package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsResourceCategory;

public interface UmsResourceCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsResourceCategory record);

    UmsResourceCategory selectByPrimaryKey(Long id);

    List<UmsResourceCategory> selectAll();

    int updateByPrimaryKey(UmsResourceCategory record);
}