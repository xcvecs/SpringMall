package top.byteinfo.springmall.mbg.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsMemberTag {
    private Long id;

    private String name;

    private Integer finishOrderCount;

    private BigDecimal finishOrderAmount;
}