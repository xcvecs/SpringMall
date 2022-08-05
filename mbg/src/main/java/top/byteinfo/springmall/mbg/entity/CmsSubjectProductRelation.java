package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CmsSubjectProductRelation {
    private Long id;

    private Long subjectId;

    private Long productId;
}