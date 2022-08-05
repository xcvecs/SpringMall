package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.PmsAlbumPic;

public interface PmsAlbumPicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsAlbumPic record);

    PmsAlbumPic selectByPrimaryKey(Long id);

    List<PmsAlbumPic> selectAll();

    int updateByPrimaryKey(PmsAlbumPic record);
}