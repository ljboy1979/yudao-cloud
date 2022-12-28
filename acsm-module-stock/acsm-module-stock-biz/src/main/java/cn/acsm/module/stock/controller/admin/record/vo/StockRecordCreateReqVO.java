package cn.acsm.module.stock.controller.admin.record.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 库存记录创建 Request VO")
@Data
@ToString(callSuper = true)
public class StockRecordCreateReqVO implements Serializable {

    @ApiModelProperty(value = "库存类型(0:原料 1:投入品 2:商品 3: 菜品 4:套餐 5:特医食品)", required = true)
    @NotNull(message = "库存类型(0:原料 1:投入品 2:商品 3: 菜品 4:套餐 5:特医食品)不能为空")
    private Integer type;

    @ApiModelProperty(value = "仓库id", required = true)
    @NotNull(message = "仓库id不能为空")
    private String warehouseId;

    @ApiModelProperty(value = "操作时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date operationTime;

    @ApiModelProperty(value = "关联单号【入库单号】")
    private String associatedDocNo;

    @ApiModelProperty(value = "部门id")
    private String departmentId;

    @ApiModelProperty(value = "负责人id")
    private Long headId;

    @ApiModelProperty(value = "库存明细信息")
    private List<StockRecordDetailCreateVO> stockRecordDetailDOList;

}
