package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmsHomeAdvertise {
    private Long id;

    private String name;

    private Integer type;

    private String pic;

    private Date startTime;

    private Date endTime;

    private Integer status;

    private Integer clickCount;

    private Integer orderCount;

    private String url;

    private String note;

    private Integer sort;
}