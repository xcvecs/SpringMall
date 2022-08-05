package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsMemberReceiveAddress {
    private Long id;

    private Long memberId;

    private String name;

    private String phoneNumber;

    private Integer defaultStatus;

    private String postCode;

    private String province;

    private String city;

    private String region;

    private String detailAddress;
}