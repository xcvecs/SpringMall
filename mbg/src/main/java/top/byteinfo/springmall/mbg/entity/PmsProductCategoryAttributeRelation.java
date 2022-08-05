package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PmsProductCategoryAttributeRelation {
    private Long id;

    private Long productCategoryId;

    private Long productAttributeId;
}