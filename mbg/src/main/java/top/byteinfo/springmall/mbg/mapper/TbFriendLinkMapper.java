package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.TbFriendLink;

public interface TbFriendLinkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbFriendLink record);

    TbFriendLink selectByPrimaryKey(Integer id);

    List<TbFriendLink> selectAll();

    int updateByPrimaryKey(TbFriendLink record);
}