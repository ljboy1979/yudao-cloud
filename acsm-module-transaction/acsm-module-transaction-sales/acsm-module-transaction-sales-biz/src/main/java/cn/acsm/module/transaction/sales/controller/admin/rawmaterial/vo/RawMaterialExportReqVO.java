package cn.acsm.module.transaction.sales.controller.admin.rawmaterial.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 原料 Excel 导出 Request VO", description = "参数和 RawMaterialPageReqVO 是一致的")
@Data
public class RawMaterialExportReqVO {

    @ApiModelProperty(value = "原料编号")
    private String ingredientNumber;

    @ApiModelProperty(value = "分类id")
    private String classify;

    @ApiModelProperty(value = "原料名称")
    private String name;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
