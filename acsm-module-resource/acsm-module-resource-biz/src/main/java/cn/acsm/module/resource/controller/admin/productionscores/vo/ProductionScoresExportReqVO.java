package cn.acsm.module.resource.controller.admin.productionscores.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 服务资源-生产品种 Excel 导出 Request VO", description = "参数和 ProductionScoresPageReqVO 是一致的")
@Data
public class ProductionScoresExportReqVO {

    @ApiModelProperty(value = "关联认养物/租凭物")
    private String serviceAdoptContentId;

    @ApiModelProperty(value = "关联生产品种")
    private String productionScoresId;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "项目来源")
    private String source;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

}
