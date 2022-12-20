package cn.acsm.module.purchase.controller.admin.inquiry.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
* 采购询价 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PurchaseInquiryBaseVO {

    @ApiModelProperty(value = "询价单编号", required = true)
    @NotNull(message = "询价单编号不能为空")
    private String enquiryId;

    @ApiModelProperty(value = "询价单名称", required = true)
    @NotNull(message = "询价单名称不能为空")
    private String enquiryName;

    @ApiModelProperty(value = "供应商id", required = true)
    @NotNull(message = "供应商id不能为空")
    private Long providerId;

    @ApiModelProperty(value = "供应商名称", required = true)
    @NotNull(message = "供应商名称不能为空")
    private String providerName;

    @ApiModelProperty(value = "发布状态（0未发布 1已发布）")
    private String postStatus;

    @ApiModelProperty(value = "询价情况（0已回复 1暂未回复）")
    private String enquiryStatus;

    @ApiModelProperty(value = "发布时间")
    private Date releaseTime;

    @ApiModelProperty(value = "是否阅读（0未读 1已读）")
    private String readStatus;

    @ApiModelProperty(value = "uid")
    private Long uid;

    @ApiModelProperty(value = "经营主体", required = true)
    @NotNull(message = "经营主体不能为空")
    private String subjectId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "租户集合")
    private Long sourceId;

}
