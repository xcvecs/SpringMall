package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsGrowthChangeHistory {
    private Long id;

    private Long memberId;

    private Date createTime;

    private Integer changeType;

    private Integer changeCount;

    private String operateMan;

    private String operateNote;

    private Integer sourceType;
}