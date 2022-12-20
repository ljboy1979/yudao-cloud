package cn.acsm.module.purchase.controller.admin.inquiry.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <pre>
 * 对象功能: PurchaseInquiryReadOrReplyVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/20
 * <pre>
 */
@ApiModel("管理后台 - 回复或阅读采购询价 Request VO")
@Data
public class PurchaseInquiryReadOrReplyVO implements Serializable {

    @ApiModelProperty(value = "询价单编号")
    @NotBlank(message = "询价单编号不能为空")
    private String enquiryId;

    @ApiModelProperty(value = "询价情况（0已回复 1暂未回复）")
    private String enquiryStatus;

    @ApiModelProperty(value = "是否阅读（0未读 1已读）")
    private String readStatus;

}
