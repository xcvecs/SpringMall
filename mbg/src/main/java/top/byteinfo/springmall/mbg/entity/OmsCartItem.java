package top.byteinfo.springmall.mbg.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OmsCartItem {
    private Long id;

    private Long productId;

    private Long productSkuId;

    private Long memberId;

    private Integer quantity;

    private BigDecimal price;

    private String productPic;

    private String productName;

    private String productSubTitle;

    private String productSkuCode;

    private String memberNickname;

    private Date createDate;

    private Date modifyDate;

    private Integer deleteStatus;

    private Long productCategoryId;

    private String productBrand;

    private String productSn;

    private String productAttr;
}