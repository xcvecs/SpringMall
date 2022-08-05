package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsRole {
    private Long id;

    private String name;

    private String description;

    private Integer adminCount;

    private Date createTime;

    private Integer status;

    private Integer sort;
}