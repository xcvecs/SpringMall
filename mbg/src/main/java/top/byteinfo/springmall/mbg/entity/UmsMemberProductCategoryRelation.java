package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsMemberProductCategoryRelation {
    private Long id;

    private Long memberId;

    private Long productCategoryId;
}