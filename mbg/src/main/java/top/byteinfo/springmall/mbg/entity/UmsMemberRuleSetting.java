package top.byteinfo.springmall.mbg.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsMemberRuleSetting {
    private Long id;

    private Integer continueSignDay;

    private Integer continueSignPoint;

    private BigDecimal consumePerPoint;

    private BigDecimal lowOrderAmount;

    private Integer maxPointPerOrder;

    private Integer type;
}