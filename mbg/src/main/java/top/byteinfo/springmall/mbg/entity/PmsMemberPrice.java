package top.byteinfo.springmall.mbg.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PmsMemberPrice {
    private Long id;

    private Long productId;

    private Long memberLevelId;

    private BigDecimal memberPrice;

    private String memberLevelName;
}