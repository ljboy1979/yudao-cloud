package cn.acsm.module.purchase.controller.admin.inquiry.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 采购询价分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PurchaseInquiryPageReqVO extends PageParam {

    @ApiModelProperty(value = "询价单编号")
    private String enquiryId;

    @ApiModelProperty(value = "询价单名称")
    private String enquiryName;

    @ApiModelProperty(value = "供应商id")
    private Long providerId;

    @ApiModelProperty(value = "供应商名称")
    private String providerName;

    @ApiModelProperty(value = "发布状态（0未发布 1已发布）")
    private String postStatus;

    @ApiModelProperty(value = "询价情况（0已回复 1暂未回复）")
    private String enquiryStatus;

    @ApiModelProperty(value = "发布时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date[] releaseTime;

    @ApiModelProperty(value = "是否阅读（0未读 1已读）")
    private String readStatus;

    @ApiModelProperty(value = "uid")
    private Long uid;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date[] createTime;

    @ApiModelProperty(value = "经营主体")
    private String subjectId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "租户集合")
    private Long sourceId;

}
