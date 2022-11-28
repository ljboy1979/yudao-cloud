package cn.iocoder.yudao.module.transaction.sales.controller.admin.commodity.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 商品 Excel 导出 Request VO", description = "参数和 CommodityPageReqVO 是一致的")
@Data
public class CommodityExportReqVO {

    @ApiModelProperty(value = "商品编号")
    private String commodityCode;

    @ApiModelProperty(value = "序号")
    private String articleNo;

    @ApiModelProperty(value = "商品条码")
    private String commodityBarCode;

    @ApiModelProperty(value = "商品名称")
    private String commodityName;

    @ApiModelProperty(value = "0 渠道商商品 1农资商城商品")
    private Boolean type;

    @ApiModelProperty(value = "排序权重")
    private Integer sort;

    @ApiModelProperty(value = "关键字")
    private String keyWord;

    @ApiModelProperty(value = "生产商")
    private String manufacturer;

    @ApiModelProperty(value = "批次")
    private String batch;

    @ApiModelProperty(value = "可销售数量")
    private Integer availableNum;

    @ApiModelProperty(value = "供应商名称")
    private String providerName;

    @ApiModelProperty(value = "供应商id")
    private String providerId;

    @ApiModelProperty(value = "原供应商id,商品来源商户")
    private String oldProviderId;

    @ApiModelProperty(value = "单位数量")
    private BigDecimal specNum;

    @ApiModelProperty(value = "多个标签id 逗号隔开")
    private String lableIds;

    @ApiModelProperty(value = "库存预警数量")
    private Long warnStockNum;

    @ApiModelProperty(value = "规格单位 字典")
    private String weightUnit;

    @ApiModelProperty(value = "包装单位 字典")
    private String packageUnit;

    @ApiModelProperty(value = "商品分类")
    private String commodityCategoryId;

    @ApiModelProperty(value = "生产商")
    private String manufacturerName;

    @ApiModelProperty(value = "批发价格")
    private BigDecimal wholesalePrice;

    @ApiModelProperty(value = "零售价格")
    private BigDecimal retailPrice;

    @ApiModelProperty(value = "库存数量")
    private Long stockNum;

    @ApiModelProperty(value = "是否上架 0下架 1上架")
    private String saleState;

    @ApiModelProperty(value = "介绍 富文本")
    private String introduction;

    @ApiModelProperty(value = "是否追溯 0-否 1-是")
    private String traceStatus;

    @ApiModelProperty(value = "库存商品分类id,关联os_plant表")
    private String plantId;

    @ApiModelProperty(value = "商品分类id,关联plant表")
    private String commodityPlantId;

    @ApiModelProperty(value = "销售类型 0-自营 1-代售")
    private String sellType;

    @ApiModelProperty(value = "增加方式 0-货单上架 1-手工上架")
    private String addType;

    @ApiModelProperty(value = "交货地址")
    private String address;

    @ApiModelProperty(value = "销售数量")
    private BigDecimal num;

    @ApiModelProperty(value = "同步状态（0未同步1已同步）")
    private String syncStatus;

    @ApiModelProperty(value = "货单上货到货时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] arriveDate;

    @ApiModelProperty(value = "0商品")
    private String commodityType;

    @ApiModelProperty(value = "商品图片")
    private String commodityImg;

    @ApiModelProperty(value = "公示单价")
    private BigDecimal publicityPrice;

    @ApiModelProperty(value = "产地")
    private String productionAddress;

    @ApiModelProperty(value = "产地地址")
    private String originPlace;

    @ApiModelProperty(value = "商品别名")
    private String antName;

    @ApiModelProperty(value = "创建的用户id")
    private String createId;

    @ApiModelProperty(value = "视频连接")
    private String videoUrl;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
