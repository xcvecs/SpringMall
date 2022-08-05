package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmsFlashPromotion {
    private Long id;

    private String title;

    private Date startDate;

    private Date endDate;

    private Integer status;

    private Date createTime;
}