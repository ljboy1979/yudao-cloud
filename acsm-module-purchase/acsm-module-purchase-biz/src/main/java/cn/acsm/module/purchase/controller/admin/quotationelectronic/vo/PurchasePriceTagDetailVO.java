package cn.acsm.module.purchase.controller.admin.quotationelectronic.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * <pre>
 * 对象功能: PurchasePriceTagDetailVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/20
 * <pre>
 */
@ApiModel("管理后台 - 报价单明细 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PurchasePriceTagDetailVO extends PageParam {

    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id", required = true)
    @NotNull(message = "商品id不能为空")
    private Long commodityId;

    /**
     * 规格id
     */
    @ApiModelProperty(value = "规格id", required = true)
    @NotNull(message = "规格id不能为空")
    private String specificationsId;

}
