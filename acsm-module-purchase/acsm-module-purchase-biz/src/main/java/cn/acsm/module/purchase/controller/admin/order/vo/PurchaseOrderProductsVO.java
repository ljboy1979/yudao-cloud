package cn.acsm.module.purchase.controller.admin.order.vo;

import cn.acsm.module.purchase.group.PurchaseOrderCreateVO;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ApiModel("管理后台 - 3.6.2.3.获取采购产品列表 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PurchaseOrderProductsVO extends PageParam {

    @ApiModelProperty(value = "采购类型(1:原料 2:投入品 3:成品 4:办公用品)")
    @NotNull(message = "采购类型不能为空", groups = { PurchaseOrderCreateVO.class })
    private String purchaseType;

}
