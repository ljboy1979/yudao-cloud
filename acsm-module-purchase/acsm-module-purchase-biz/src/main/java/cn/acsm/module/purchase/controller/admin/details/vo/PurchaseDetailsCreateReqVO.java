package cn.acsm.module.purchase.controller.admin.details.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ApiModel("管理后台 - 采购单明细创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PurchaseDetailsCreateReqVO extends PurchaseDetailsBaseVO {

}
