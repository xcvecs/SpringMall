package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OmsOrderOperateHistory {
    private Long id;

    private Long orderId;

    private String operateMan;

    private Date createTime;

    private Integer orderStatus;

    private String note;
}