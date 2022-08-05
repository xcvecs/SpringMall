package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OmsCompanyAddress {
    private Long id;

    private String addressName;

    private Integer sendStatus;

    private Integer receiveStatus;

    private String name;

    private String phone;

    private String province;

    private String city;

    private String region;

    private String detailAddress;
}