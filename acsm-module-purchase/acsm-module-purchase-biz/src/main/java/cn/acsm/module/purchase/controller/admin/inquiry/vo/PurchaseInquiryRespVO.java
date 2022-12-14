package cn.acsm.module.purchase.controller.admin.inquiry.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@ApiModel("管理后台 - 采购询价电子 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PurchaseInquiryRespVO extends PurchaseInquiryBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
