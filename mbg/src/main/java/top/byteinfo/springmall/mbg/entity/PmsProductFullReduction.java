package top.byteinfo.springmall.mbg.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PmsProductFullReduction {
    private Long id;

    private Long productId;

    private BigDecimal fullPrice;

    private BigDecimal reducePrice;
}