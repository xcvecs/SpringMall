package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.TbUserAuth;

public interface TbUserAuthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUserAuth record);

    TbUserAuth selectByPrimaryKey(Integer id);

    List<TbUserAuth> selectAll();

    int updateByPrimaryKey(TbUserAuth record);
}