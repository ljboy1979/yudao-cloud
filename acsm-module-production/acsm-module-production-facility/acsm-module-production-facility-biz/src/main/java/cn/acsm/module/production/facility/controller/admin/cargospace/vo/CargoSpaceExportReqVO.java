package cn.acsm.module.production.facility.controller.admin.cargospace.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 设施货位 Excel 导出 Request VO", description = "参数和 CargoSpacePageReqVO 是一致的")
@Data
public class CargoSpaceExportReqVO {

    @ApiModelProperty(value = "货位号")
    private String spaceCode;

    @ApiModelProperty(value = "行数")
    private Integer spaceRowNumber;

    @ApiModelProperty(value = "列数")
    private Integer spaceColumnNumber;

    @ApiModelProperty(value = "层数")
    private Integer spaceLayerNumber;

    @ApiModelProperty(value = "设施")
    private Integer facilityId;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
