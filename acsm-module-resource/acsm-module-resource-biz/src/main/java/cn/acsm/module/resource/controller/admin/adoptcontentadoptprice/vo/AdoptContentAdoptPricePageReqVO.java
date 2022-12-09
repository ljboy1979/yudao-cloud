package cn.acsm.module.resource.controller.admin.adoptcontentadoptprice.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 认养/租凭价格分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AdoptContentAdoptPricePageReqVO extends PageParam {

    @ApiModelProperty(value = "认养物的id")
    private String adoptId;

    @ApiModelProperty(value = "认养物的名称")
    private String adoptName;

    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] startTime;

    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] endTime;

    @ApiModelProperty(value = "认养费用")
    private BigDecimal adoptPriceFee;

    @ApiModelProperty(value = "费用类型")
    private String feeType;

    @ApiModelProperty(value = "认养人标签")
    private String adoptPersonFlag;

    @ApiModelProperty(value = "权益价格的id")
    private String adoptRightId;

    @ApiModelProperty(value = "付款人数")
    private String payNum;

    @ApiModelProperty(value = "认养总数")
    private String adoptTotal;

    @ApiModelProperty(value = "认养剩余名额")
    private String adoptQuota;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "项目来源")
    private String source;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "多个认养物的id")
    private String adoptIds;

}
