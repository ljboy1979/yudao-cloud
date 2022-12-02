package cn.acsm.module.transaction.sales.controller.admin.packageorganization.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 套餐组成 Excel 导出 Request VO", description = "参数和 PackageOrganizationPageReqVO 是一致的")
@Data
public class PackageOrganizationExportReqVO {

    @ApiModelProperty(value = "套餐id")
    private String packageId;

    @ApiModelProperty(value = "0商品 1菜品")
    private String type;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
