package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.TbTalk;

public interface TbTalkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbTalk record);

    TbTalk selectByPrimaryKey(Integer id);

    List<TbTalk> selectAll();

    int updateByPrimaryKey(TbTalk record);
}