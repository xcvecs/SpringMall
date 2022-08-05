package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsAdminRoleRelation {
    private Long id;

    private Long adminId;

    private Long roleId;
}