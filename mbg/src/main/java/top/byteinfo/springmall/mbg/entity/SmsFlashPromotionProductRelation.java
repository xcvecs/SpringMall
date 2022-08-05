package top.byteinfo.springmall.mbg.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmsFlashPromotionProductRelation {
    private Long id;

    private Long flashPromotionId;

    private Long flashPromotionSessionId;

    private Long productId;

    private BigDecimal flashPromotionPrice;

    private Integer flashPromotionCount;

    private Integer flashPromotionLimit;

    private Integer sort;
}