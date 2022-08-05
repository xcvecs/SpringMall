package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsPermission {
    private Long id;

    private Long pid;

    private String name;

    private String value;

    private String icon;

    private Integer type;

    private String uri;

    private Integer status;

    private Date createTime;

    private Integer sort;
}