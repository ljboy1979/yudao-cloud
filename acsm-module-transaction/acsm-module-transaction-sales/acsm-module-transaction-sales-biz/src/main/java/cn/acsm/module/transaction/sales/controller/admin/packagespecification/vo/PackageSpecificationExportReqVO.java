package cn.acsm.module.transaction.sales.controller.admin.packagespecification.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 套餐规格 Excel 导出 Request VO", description = "参数和 PackageSpecificationPageReqVO 是一致的")
@Data
public class PackageSpecificationExportReqVO {

    @ApiModelProperty(value = "规格名称")
    private String specificationsName;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    protected Date[] createTime;

}
