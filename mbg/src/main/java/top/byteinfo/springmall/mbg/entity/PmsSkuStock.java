package top.byteinfo.springmall.mbg.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PmsSkuStock {
    private Long id;

    private Long productId;

    private String skuCode;

    private BigDecimal price;

    private Integer stock;

    private Integer lowStock;

    private String pic;

    private Integer sale;

    private BigDecimal promotionPrice;

    private Integer lockStock;

    private String spData;
}