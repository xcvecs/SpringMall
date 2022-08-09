package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TbUserRole {
    private Integer id;

    private Integer userId;

    private Integer roleId;
}