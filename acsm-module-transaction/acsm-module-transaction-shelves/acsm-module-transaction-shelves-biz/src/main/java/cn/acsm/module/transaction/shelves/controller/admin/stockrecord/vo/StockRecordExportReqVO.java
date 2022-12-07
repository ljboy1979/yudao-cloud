package cn.acsm.module.transaction.shelves.controller.admin.stockrecord.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 货架库存记录 Excel 导出 Request VO", description = "参数和 StockRecordPageReqVO 是一致的")
@Data
public class StockRecordExportReqVO {

    @ApiModelProperty(value = "货架规格id")
    private String specificationsId;

    @ApiModelProperty(value = "类型 0 上架 1下架 2销售 3报损 4退货")
    private String type;

    @ApiModelProperty(value = "操作量")
    private BigDecimal amount;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

    @ApiModelProperty(value = "source")
    private String source;

}
