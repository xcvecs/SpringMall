package top.byteinfo.springmall.mbg.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsMemberStatisticsInfo {
    private Long id;

    private Long memberId;

    private BigDecimal consumeAmount;

    private Integer orderCount;

    private Integer couponCount;

    private Integer commentCount;

    private Integer returnOrderCount;

    private Integer loginCount;

    private Integer attendCount;

    private Integer fansCount;

    private Integer collectProductCount;

    private Integer collectSubjectCount;

    private Integer collectTopicCount;

    private Integer collectCommentCount;

    private Integer inviteFriendCount;

    private Date recentOrderTime;
}