package top.byteinfo.springmall.mbg.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmsCoupon {
    private Long id;

    private Integer type;

    private String name;

    private Integer platform;

    private Integer count;

    private BigDecimal amount;

    private Integer perLimit;

    private BigDecimal minPoint;

    private Date startTime;

    private Date endTime;

    private Integer useType;

    private String note;

    private Integer publishCount;

    private Integer useCount;

    private Integer receiveCount;

    private Date enableTime;

    private String code;

    private Integer memberLevel;
}