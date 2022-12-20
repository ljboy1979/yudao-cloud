package cn.acsm.module.purchase.controller.admin.inquiry.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <pre>
 * 对象功能: PurchaseInquiryGetVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/20
 * <pre>
 */
@ApiModel("管理后台 - 供应商获取采购询价 Request VO")
@Data
public class PurchaseInquiryGetVO extends PageParam implements Serializable {

    @ApiModelProperty(value = "供应商id", required = true)
    @NotNull(message = "供应商id不能为空")
    private Long providerId;

    @ApiModelProperty(value = "发布状态（0未发布 1已发布）")
    @NotBlank(message = "发布状态不能为空")
    private String postStatus;

    @ApiModelProperty(value = "询价情况（0已回复 1暂未回复）")
    @NotBlank(message = "询价情况不能为空")
    private String enquiryStatus;

    @ApiModelProperty(value = "是否阅读（0未读 1已读）")
    @NotBlank(message = "是否阅读不能为空")
    private String readStatus;

}
