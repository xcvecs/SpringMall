package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsMemberLoginLog {
    private Long id;

    private Long memberId;

    private Date createTime;

    private String ip;

    private String city;

    private Integer loginType;

    private String province;
}