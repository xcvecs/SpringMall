package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsRolePermissionRelation {
    private Long id;

    private Long roleId;

    private Long permissionId;
}