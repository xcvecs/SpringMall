package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsAdminLoginLog {
    private Long id;

    private Long adminId;

    private Date createTime;

    private String ip;

    private String address;

    private String userAgent;
}