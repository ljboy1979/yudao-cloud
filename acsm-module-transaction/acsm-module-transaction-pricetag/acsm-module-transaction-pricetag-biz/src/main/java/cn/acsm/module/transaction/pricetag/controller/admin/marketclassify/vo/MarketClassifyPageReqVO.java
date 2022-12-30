package cn.acsm.module.transaction.pricetag.controller.admin.marketclassify.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 市场分类分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MarketClassifyPageReqVO extends PageParam {

    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    @ApiModelProperty(value = "层次级别", required = true)
    //@NotNull(message = "层次级别不能为空")
    private BigDecimal treeLevel;
    @ApiModelProperty(value = "父级编号", required = true)
    //NotNull(message = "父级编号不能为空")
    private String parentCode;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] updateTime;

}
