package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmsHomeRecommendProduct {
    private Long id;

    private Long productId;

    private String productName;

    private Integer recommendStatus;

    private Integer sort;
}