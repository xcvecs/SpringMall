package top.byteinfo.springmall.mbg.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsMemberLevel {
    private Long id;

    private String name;

    private Integer growthPoint;

    private Integer defaultStatus;

    private BigDecimal freeFreightPoint;

    private Integer commentGrowthPoint;

    private Integer priviledgeFreeFreight;

    private Integer priviledgeSignIn;

    private Integer priviledgeComment;

    private Integer priviledgePromotion;

    private Integer priviledgeMemberPrice;

    private Integer priviledgeBirthday;

    private String note;
}