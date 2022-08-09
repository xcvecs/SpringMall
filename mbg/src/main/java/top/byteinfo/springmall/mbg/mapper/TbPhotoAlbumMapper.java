package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.TbPhotoAlbum;

public interface TbPhotoAlbumMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbPhotoAlbum record);

    TbPhotoAlbum selectByPrimaryKey(Integer id);

    List<TbPhotoAlbum> selectAll();

    int updateByPrimaryKey(TbPhotoAlbum record);
}