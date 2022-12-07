package cn.acsm.module.transaction.shelves.controller.admin.shelves.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 货架 Excel 导出 Request VO", description = "参数和 shelvesPageReqVO 是一致的")
@Data
public class ShelvesExportReqVO {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "分类id")
    private String classifyId;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
