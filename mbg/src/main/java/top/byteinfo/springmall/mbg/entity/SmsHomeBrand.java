package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmsHomeBrand {
    private Long id;

    private Long brandId;

    private String brandName;

    private Integer recommendStatus;

    private Integer sort;
}