package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TbPhoto {
    private Integer id;

    private Integer albumId;

    private String photoName;

    private String photoDesc;

    private String photoSrc;

    private Boolean isDelete;

    private Date createTime;

    private Date updateTime;
}