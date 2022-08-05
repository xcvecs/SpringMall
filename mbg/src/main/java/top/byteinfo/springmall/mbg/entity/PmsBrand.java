package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PmsBrand {
    private Long id;

    private String name;

    private String firstLetter;

    private Integer sort;

    private Integer factoryStatus;

    private Integer showStatus;

    private Integer productCount;

    private Integer productCommentCount;

    private String logo;

    private String bigPic;

    private String brandStory;
}