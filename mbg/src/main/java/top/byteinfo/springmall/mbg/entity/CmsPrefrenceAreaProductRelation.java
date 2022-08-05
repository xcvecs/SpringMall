package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CmsPrefrenceAreaProductRelation {
    private Long id;

    private Long prefrenceAreaId;

    private Long productId;
}