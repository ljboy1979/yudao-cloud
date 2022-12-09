package cn.acsm.module.resource.controller.admin.adoptright.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 认养/租凭权益分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AdoptRightPageReqVO extends PageParam {

    @ApiModelProperty(value = "权益类型")
    private String rightType;

    @ApiModelProperty(value = "权益描述")
    private String rightDescription;

    @ApiModelProperty(value = "认养时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] adoptTime;

    @ApiModelProperty(value = "认养物编号")
    private String adoptContentNum;

    @ApiModelProperty(value = "收入项：收入金额：收入比例")
    private String incomeItemAmountScale;

    @ApiModelProperty(value = "收入有效日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] incomeEffectiveDate;

    @ApiModelProperty(value = "租用人标签")
    private String leasePersonFlag;

    @ApiModelProperty(value = "权益价格的id")
    private String adoptRightId;

    @ApiModelProperty(value = "金额")
    private String price;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "项目来源")
    private String source;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

}
