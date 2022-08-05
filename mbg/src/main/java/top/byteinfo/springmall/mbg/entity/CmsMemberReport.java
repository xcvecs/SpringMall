package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CmsMemberReport {
    private Long id;

    private Integer reportType;

    private String reportMemberName;

    private Date createTime;

    private String reportObject;

    private Integer reportStatus;

    private Integer handleStatus;

    private String note;
}