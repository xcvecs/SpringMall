package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TbRoleResource {
    private Integer id;

    private Integer roleId;

    private Integer resourceId;
}