package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PmsProductVertifyRecord {
    private Long id;

    private Long productId;

    private Date createTime;

    private String vertifyMan;

    private Integer status;

    private String detail;
}