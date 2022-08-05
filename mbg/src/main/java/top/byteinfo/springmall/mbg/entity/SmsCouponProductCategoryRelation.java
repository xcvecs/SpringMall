package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmsCouponProductCategoryRelation {
    private Long id;

    private Long couponId;

    private Long productCategoryId;

    private String productCategoryName;

    private String parentCategoryName;
}