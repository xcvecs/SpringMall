package top.byteinfo.springmall.mbg.mapper;

import java.util.List;
import top.byteinfo.springmall.mbg.entity.PmsAlbum;

public interface PmsAlbumMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsAlbum record);

    PmsAlbum selectByPrimaryKey(Long id);

    List<PmsAlbum> selectAll();

    int updateByPrimaryKey(PmsAlbum record);
}