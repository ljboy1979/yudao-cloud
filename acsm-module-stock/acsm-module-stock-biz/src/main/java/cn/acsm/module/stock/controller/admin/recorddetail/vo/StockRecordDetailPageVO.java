package cn.acsm.module.stock.controller.admin.recorddetail.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * <pre>
 * 对象功能: StockRecordDetailPageVO.java
 * 开发人员: 崔高杰
 * 创建时间: 2022/12/22
 * <pre>
 */
@ApiModel("管理后台 - 库存记录字表-明细分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockRecordDetailPageVO extends PageParam {

    @ApiModelProperty(value = "库存批次号")
    @NotBlank(message = "库存批次号不能为空")
    private String stockBatchNo;

    @ApiModelProperty(value = "操作类型(0.入库 1.出库)")
    @NotNull(message = "操作类型不能为空")
    private Boolean operationType;

    @ApiModelProperty(value = "货品名称")
    private String goodsName;

    @ApiModelProperty(value = "货品类型")
    @NotBlank(message = "货品类型不能为空")
    private String goodsType;

}
