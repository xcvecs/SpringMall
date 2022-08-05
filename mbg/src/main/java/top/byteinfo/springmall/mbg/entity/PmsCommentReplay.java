package top.byteinfo.springmall.mbg.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PmsCommentReplay {
    private Long id;

    private Long commentId;

    private String memberNickName;

    private String memberIcon;

    private String content;

    private Date createTime;

    private Integer type;
}