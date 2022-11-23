package cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 企业政策补贴信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PolicySubsidiesInfoPageReqVO extends PageParam {

    @ApiModelProperty(value = "编号")
    private Long id;

    @ApiModelProperty(value = "经营主体ID")
    private Long enterpriseId;

    @ApiModelProperty(value = "补贴种类")
    private String subsidiesCategory;

    @ApiModelProperty(value = "补贴名称")
    private String subsidiesName;

    @ApiModelProperty(value = "补贴金额")
    private BigDecimal subsidiesAmount;

    @ApiModelProperty(value = "补贴方式")
    private String subsidiesType;

    @ApiModelProperty(value = "补贴状态")
    private Integer subsidiesStatus;

    @ApiModelProperty(value = "申请人")
    private String applyPerson;

    @ApiModelProperty(value = "申请时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] applyTime;

    @ApiModelProperty(value = "租户编号")
    private Long tenantId;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

    @ApiModelProperty(value = "创建者")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "更新者")
    private String updater;

    @ApiModelProperty(value = "更新时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] updateTime;

}
