package cn.acsm.module.purchase.controller.admin.inquiry.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <pre>
 * 对象功能: PurchaseInquiryDelReqVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/19
 * <pre>
 */
@ApiModel("管理后台 - 采购询价删除 Request VO")
@Data
public class PurchaseInquiryDelReqVO implements Serializable {

    @ApiModelProperty(value = "id", required = true)
    private Long id;

    @ApiModelProperty(value = "询价单编号", required = true)
    private String enquiryId;

}
