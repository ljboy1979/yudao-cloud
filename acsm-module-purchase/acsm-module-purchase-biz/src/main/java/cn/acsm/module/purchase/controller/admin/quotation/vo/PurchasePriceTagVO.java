package cn.acsm.module.purchase.controller.admin.quotation.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * <pre>
 * 对象功能: PurchasePriceTagVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/20
 * <pre>
 */
@ApiModel("管理后台 - 获取价格牌 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PurchasePriceTagVO extends PageParam {

    @ApiModelProperty(value = "采购商id", required = true)
    @NotNull(message = "采购商id不能为空")
    private Long purchaserId;

    @ApiModelProperty(value = "商品名称")
    private String commodityName;

}
