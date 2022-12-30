package cn.acsm.module.stock.controller.admin.recorddetail.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel("管理后台 - 库存记录字表-明细 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StockRecordDetailRespVO extends StockRecordDetailBaseVO {

    @ApiModelProperty(value = "库存记录明细id", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "地块名称")
    private String tunnelName;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "部门名称")
    private String departmentName;

    @ApiModelProperty(value = "优惠")
    private BigDecimal discountPrice;

    @ApiModelProperty(value = "货位名称")
    private String goodsAllocationName;

    @ApiModelProperty(value = "所属部门id")
    private Long departmentId;

}
