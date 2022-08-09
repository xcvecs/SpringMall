package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.TbUserRole;

public interface TbUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUserRole record);

    TbUserRole selectByPrimaryKey(Integer id);

    List<TbUserRole> selectAll();

    int updateByPrimaryKey(TbUserRole record);
}