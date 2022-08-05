package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CmsTopic {
    private Long id;

    private Long categoryId;

    private String name;

    private Date createTime;

    private Date startTime;

    private Date endTime;

    private Integer attendCount;

    private Integer attentionCount;

    private Integer readCount;

    private String awardName;

    private String attendType;

    private String content;
}