package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.TbUserInfo;

public interface TbUserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUserInfo record);

    TbUserInfo selectByPrimaryKey(Integer id);

    List<TbUserInfo> selectAll();

    int updateByPrimaryKey(TbUserInfo record);
}