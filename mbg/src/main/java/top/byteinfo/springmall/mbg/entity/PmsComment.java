package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PmsComment {
    private Long id;

    private Long productId;

    private String memberNickName;

    private String productName;

    private Integer star;

    private String memberIp;

    private Date createTime;

    private Integer showStatus;

    private String productAttribute;

    private Integer collectCouont;

    private Integer readCount;

    private String pics;

    private String memberIcon;

    private Integer replayCount;

    private String content;
}