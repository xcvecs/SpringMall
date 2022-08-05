package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmsCouponHistory {
    private Long id;

    private Long couponId;

    private Long memberId;

    private String couponCode;

    private String memberNickname;

    private Integer getType;

    private Date createTime;

    private Integer useStatus;

    private Date useTime;

    private Long orderId;

    private String orderSn;
}