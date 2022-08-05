package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmsCouponProductRelation {
    private Long id;

    private Long couponId;

    private Long productId;

    private String productName;

    private String productSn;
}