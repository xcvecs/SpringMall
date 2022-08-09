package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.TbPhoto;

public interface TbPhotoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbPhoto record);

    TbPhoto selectByPrimaryKey(Integer id);

    List<TbPhoto> selectAll();

    int updateByPrimaryKey(TbPhoto record);
}