package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PmsProductAttributeCategory {
    private Long id;

    private String name;

    private Integer attributeCount;

    private Integer paramCount;
}