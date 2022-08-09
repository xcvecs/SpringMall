package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.TbMenu;

public interface TbMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbMenu record);

    TbMenu selectByPrimaryKey(Integer id);

    List<TbMenu> selectAll();

    int updateByPrimaryKey(TbMenu record);
}