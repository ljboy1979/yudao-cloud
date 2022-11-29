package cn.acsm.module.transaction.sales.controller.admin.inputsinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 投入品 Excel 导出 Request VO", description = "参数和 InputsInfoPageReqVO 是一致的")
@Data
public class InputsInfoExportReqVO {

    @ApiModelProperty(value = "投入品名称")
    private String inputsName;

    @ApiModelProperty(value = "种类")
    private String inputsKind;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
