package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsIntegrationConsumeSetting {
    private Long id;

    private Integer deductionPerAmount;

    private Integer maxPercentPerOrder;

    private Integer useUnit;

    private Integer couponStatus;
}