package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsResource {
    private Long id;

    private Date createTime;

    private String name;

    private String url;

    private String description;

    private Long categoryId;
}