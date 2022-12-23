package cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 盘点记录表子表-明细分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockInventoryRecordDetailPageReqVO extends PageParam {

    @ApiModelProperty(value = "库存记录id")
    private Long stockRecordId;

    @ApiModelProperty(value = "库存批次号")
    private String stockBatchNo;

    @ApiModelProperty(value = "库存记录明细id")
    private Long stockRecordDetailId;

    @ApiModelProperty(value = "库存类型(1.原料 2.投入品 3.成品 4.办公用品)")
    private Integer type;

    @ApiModelProperty(value = "二级分类(成品类：套餐/商品/特医食品)")
    private String secondaryClassification;

    @ApiModelProperty(value = "货品id")
    private String goodsId;

    @ApiModelProperty(value = "货品编号")
    private String goodsNumber;

    @ApiModelProperty(value = "货品名称")
    private String goodsName;

    @ApiModelProperty(value = "货品类型")
    private String goodsType;

    @ApiModelProperty(value = "包装规格id")
    private Long packagingSpecificationId;

    @ApiModelProperty(value = "包装规格")
    private String packagingSpecification;

    @ApiModelProperty(value = "包装规格名称")
    private String packagingSpecificationName;

    @ApiModelProperty(value = "包装类型")
    private String packagingType;

    @ApiModelProperty(value = "盘点前数量")
    private Integer inventoryFrontQuantity;

    @ApiModelProperty(value = "盘点后数量")
    private Integer inventoryAfterQuantity;

    @ApiModelProperty(value = "货位id")
    private Long goodsAllocationId;

    @ApiModelProperty(value = "货位号")
    private String goodsAllocationNo;

    @ApiModelProperty(value = "来源/去向说明")
    private String sourceTo;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "经营主体")
    private String subjectId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "租户集合")
    private Long sourceId;

}
