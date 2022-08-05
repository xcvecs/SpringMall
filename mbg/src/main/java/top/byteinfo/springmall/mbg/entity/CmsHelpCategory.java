package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CmsHelpCategory {
    private Long id;

    private String name;

    private String icon;

    private Integer helpCount;

    private Integer showStatus;

    private Integer sort;
}