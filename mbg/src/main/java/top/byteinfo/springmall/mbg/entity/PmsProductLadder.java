package top.byteinfo.springmall.mbg.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PmsProductLadder {
    private Long id;

    private Long productId;

    private Integer count;

    private BigDecimal discount;

    private BigDecimal price;
}