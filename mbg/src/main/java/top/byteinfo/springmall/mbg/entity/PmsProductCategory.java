package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PmsProductCategory {
    private Long id;

    private Long parentId;

    private String name;

    private Integer level;

    private Integer productCount;

    private String productUnit;

    private Integer navStatus;

    private Integer showStatus;

    private Integer sort;

    private String icon;

    private String keywords;

    private String description;
}