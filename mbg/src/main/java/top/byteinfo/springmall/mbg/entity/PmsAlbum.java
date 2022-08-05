package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PmsAlbum {
    private Long id;

    private String name;

    private String coverPic;

    private Integer picCount;

    private Integer sort;

    private String description;
}