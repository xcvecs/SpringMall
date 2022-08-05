package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.UmsMenu;

public interface UmsMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMenu record);

    UmsMenu selectByPrimaryKey(Long id);

    List<UmsMenu> selectAll();

    int updateByPrimaryKey(UmsMenu record);
}