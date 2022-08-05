package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsMemberTask {
    private Long id;

    private String name;

    private Integer growth;

    private Integer intergration;

    private Integer type;
}