package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsMenu {
    private Long id;

    private Long parentId;

    private Date createTime;

    private String title;

    private Integer level;

    private Integer sort;

    private String name;

    private String icon;

    private Integer hidden;
}