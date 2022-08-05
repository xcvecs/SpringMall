package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PmsAlbumPic {
    private Long id;

    private Long albumId;

    private String pic;
}