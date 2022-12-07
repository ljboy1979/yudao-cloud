package cn.acsm.module.transaction.shelves.controller.admin.specifications.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 货架规格 Excel 导出 Request VO", description = "参数和 SpecificationsPageReqVO 是一致的")
@Data
public class SpecificationsExportReqVO {

    @ApiModelProperty(value = "规格名称")
    private String specificationsName;

    @ApiModelProperty(value = "包装类型(0定装1散装)")
    private String packagingType;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
