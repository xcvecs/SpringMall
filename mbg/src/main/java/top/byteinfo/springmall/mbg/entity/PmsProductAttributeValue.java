package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PmsProductAttributeValue {
    private Long id;

    private Long productId;

    private Long productAttributeId;

    private String value;
}