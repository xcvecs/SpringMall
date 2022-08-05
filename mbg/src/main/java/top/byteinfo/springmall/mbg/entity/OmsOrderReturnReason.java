package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OmsOrderReturnReason {
    private Long id;

    private String name;

    private Integer sort;

    private Integer status;

    private Date createTime;
}