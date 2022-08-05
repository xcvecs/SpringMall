package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CmsSubject {
    private Long id;

    private Long categoryId;

    private String title;

    private String pic;

    private Integer productCount;

    private Integer recommendStatus;

    private Date createTime;

    private Integer collectCount;

    private Integer readCount;

    private Integer commentCount;

    private String albumPics;

    private String description;

    private Integer showStatus;

    private Integer forwardCount;

    private String categoryName;

    private String content;
}