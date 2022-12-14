package cn.acsm.module.purchase.controller.admin.receivingstandard.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 收货标准 Excel 导出 Request VO", description = "参数和 PurchaseReceivingStandardPageReqVO 是一致的")
@Data
public class PurchaseReceivingStandardExportReqVO {

    @ApiModelProperty(value = "标准名称")
    private String standardName;

    @ApiModelProperty(value = "范围上限")
    private String upperRange;

    @ApiModelProperty(value = "范围下限")
    private String lowerRange;

    @ApiModelProperty(value = "单位")
    private String company;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "经营主体")
    private String subjectId;

}
