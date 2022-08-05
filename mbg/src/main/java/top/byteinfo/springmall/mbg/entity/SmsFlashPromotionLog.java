package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmsFlashPromotionLog {
    private Integer id;

    private Integer memberId;

    private Long productId;

    private String memberPhone;

    private String productName;

    private Date subscribeTime;

    private Date sendTime;
}