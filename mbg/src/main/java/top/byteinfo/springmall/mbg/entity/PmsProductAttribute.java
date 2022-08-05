package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PmsProductAttribute {
    private Long id;

    private Long productAttributeCategoryId;

    private String name;

    private Integer selectType;

    private Integer inputType;

    private String inputList;

    private Integer sort;

    private Integer filterType;

    private Integer searchType;

    private Integer relatedStatus;

    private Integer handAddStatus;

    private Integer type;
}