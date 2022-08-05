package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmsFlashPromotionSession {
    private Long id;

    private String name;

    private Date startTime;

    private Date endTime;

    private Integer status;

    private Date createTime;
}