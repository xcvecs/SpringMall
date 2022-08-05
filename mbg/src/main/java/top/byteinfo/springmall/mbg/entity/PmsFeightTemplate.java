package top.byteinfo.springmall.mbg.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PmsFeightTemplate {
    private Long id;

    private String name;

    private Integer chargeType;

    private BigDecimal firstWeight;

    private BigDecimal firstFee;

    private BigDecimal continueWeight;

    private BigDecimal continmeFee;

    private String dest;
}