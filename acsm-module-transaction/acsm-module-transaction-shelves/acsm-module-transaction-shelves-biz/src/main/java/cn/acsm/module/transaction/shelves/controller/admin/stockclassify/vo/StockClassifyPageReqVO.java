package cn.acsm.module.transaction.shelves.controller.admin.stockclassify.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 库存分类分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockClassifyPageReqVO extends PageParam {

    @ApiModelProperty(value = "分类名称")
    private String classifyName;

    @ApiModelProperty(value = "层次级别")
    private BigDecimal treeLevel;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
