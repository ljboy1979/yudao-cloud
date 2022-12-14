package cn.acsm.module.purchase.controller.admin.deliver.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ApiModel("管理后台 - 采购交付创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PurchaseDeliverCreateReqVO extends PurchaseDeliverBaseVO {

}
