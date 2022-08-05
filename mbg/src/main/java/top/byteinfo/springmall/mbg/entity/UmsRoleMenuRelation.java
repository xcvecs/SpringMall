package top.byteinfo.springmall.mbg.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UmsRoleMenuRelation {
    private Long id;

    private Long roleId;

    private Long menuId;
}