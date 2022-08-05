package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsAdminPermissionRelation {
    private Long id;

    private Long adminId;

    private Long permissionId;

    private Integer type;
}