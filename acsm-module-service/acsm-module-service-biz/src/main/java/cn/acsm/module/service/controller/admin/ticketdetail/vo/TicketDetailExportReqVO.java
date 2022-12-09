package cn.acsm.module.service.controller.admin.ticketdetail.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 套票详情 Excel 导出 Request VO", description = "参数和 TicketDetailPageReqVO 是一致的")
@Data
public class TicketDetailExportReqVO {

    @ApiModelProperty(value = "套票id")
    private String ticketId;

    @ApiModelProperty(value = "商品id")
    private String skuId;

    @ApiModelProperty(value = "每次兑换数量")
    private Integer useNumber;

    @ApiModelProperty(value = "兑换频次 0 年 1月 ")
    private Integer useRate;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "项目来源")
    private String source;

}
