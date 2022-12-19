package cn.acsm.module.purchase.controller.admin.receivingstandard.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 收货标准 Excel 导出 Request VO", description = "参数和 PurchaseReceivingStandardPageReqVO 是一致的")
@Data
public class PurchaseReceivingStandardExportReqVO {

    @ApiModelProperty(value = "标准名称")
    private String name;

    @ApiModelProperty(value = "范围上限")
    private BigDecimal upperLimit;

    @ApiModelProperty(value = "范围下限")
    private BigDecimal lowerLimit;

    @ApiModelProperty(value = "单位(字典id)")
    private String unit;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date[] createTime;

    @ApiModelProperty(value = "经营主体")
    private String subjectId;

}
