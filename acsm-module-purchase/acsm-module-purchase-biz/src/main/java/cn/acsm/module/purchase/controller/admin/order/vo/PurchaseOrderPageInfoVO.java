package cn.acsm.module.purchase.controller.admin.order.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 采购单分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PurchaseOrderPageInfoVO extends PageParam {

    @ApiModelProperty(value = "供应商名称")
    private String providerName;

    @ApiModelProperty(value = "供应商联系方式")
    private String providerPhone;

    @ApiModelProperty(value = "采购时间【开始时间】")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date purchaseStartTime;

    @ApiModelProperty(value = "采购时间【结束时间】")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date purchaseEndTime;

    @ApiModelProperty(value = "经营主体")
    @NotBlank(message = "经营主体不能为空")
    private String subjectId;

    @ApiModelProperty(value = "租户编号", required = true)
    @NotBlank(message = "租户编号不能为空")
    private String tenantId;

    @ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id不能为空")
    private Long userId;

    @ApiModelProperty(value = "租户集合", required = true)
    @NotNull(message = "租户集合不能为空")
    private Long sourceId;


}
