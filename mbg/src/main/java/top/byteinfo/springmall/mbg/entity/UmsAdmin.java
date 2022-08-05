package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsAdmin {
    private Long id;

    private String username;

    private String password;

    private String icon;

    private String email;

    private String nickName;

    private String note;

    private Date createTime;

    private Date loginTime;

    private Integer status;
}