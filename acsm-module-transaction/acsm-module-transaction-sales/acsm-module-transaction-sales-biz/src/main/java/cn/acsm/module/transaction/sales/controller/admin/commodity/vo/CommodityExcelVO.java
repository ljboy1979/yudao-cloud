package cn.acsm.module.transaction.sales.controller.admin.commodity.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 商品 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class CommodityExcelVO {

    @ExcelProperty("商品id")
    private String id;

    @ExcelProperty("商品编号")
    private String commodityCode;

    @ExcelProperty("序号")
    private String articleNo;

    @ExcelProperty("商品条码")
    private String commodityBarCode;

    @ExcelProperty("商品名称")
    private String commodityName;

    @ExcelProperty("0 渠道商商品 1农资商城商品")
    private Boolean type;

    @ExcelProperty("排序权重")
    private Integer sort;

    @ExcelProperty("关键字")
    private String keyWord;

    @ExcelProperty("生产商")
    private String manufacturer;

    @ExcelProperty("批次")
    private String batch;

    @ExcelProperty("可销售数量")
    private Integer availableNum;

    @ExcelProperty("供应商名称")
    private String providerName;

    @ExcelProperty("供应商id")
    private String providerId;

    @ExcelProperty("原供应商id,商品来源商户")
    private String oldProviderId;

    @ExcelProperty("单位数量")
    private BigDecimal specNum;

    @ExcelProperty("多个标签id 逗号隔开")
    private String lableIds;

    @ExcelProperty("库存预警数量")
    private Long warnStockNum;

    @ExcelProperty("规格单位 字典")
    private String weightUnit;

    @ExcelProperty("包装单位 字典")
    private String packageUnit;

    @ExcelProperty("商品分类")
    private String commodityCategoryId;

    @ExcelProperty("生产商")
    private String manufacturerName;

    @ExcelProperty("批发价格")
    private BigDecimal wholesalePrice;

    @ExcelProperty("零售价格")
    private BigDecimal retailPrice;

    @ExcelProperty("库存数量")
    private Long stockNum;

    @ExcelProperty("是否上架 0下架 1上架")
    private String saleState;

    @ExcelProperty("介绍 富文本")
    private String introduction;

    @ExcelProperty("是否追溯 0-否 1-是")
    private String traceStatus;

    @ExcelProperty("库存商品分类id,关联os_plant表")
    private String plantId;

    @ExcelProperty("商品分类id,关联plant表")
    private String commodityPlantId;

    @ExcelProperty("销售类型 0-自营 1-代售")
    private String sellType;

    @ExcelProperty("增加方式 0-货单上架 1-手工上架")
    private String addType;

    @ExcelProperty("交货地址")
    private String address;

    @ExcelProperty("销售数量")
    private BigDecimal num;

    @ExcelProperty("同步状态（0未同步1已同步）")
    private String syncStatus;

    @ExcelProperty("货单上货到货时间")
    private Date arriveDate;

    @ExcelProperty("0商品")
    private String commodityType;

    @ExcelProperty("商品图片")
    private String commodityImg;

    @ExcelProperty("公示单价")
    private BigDecimal publicityPrice;

    @ExcelProperty("产地")
    private String productionAddress;

    @ExcelProperty("产地地址")
    private String originPlace;

    @ExcelProperty("商品别名")
    private String antName;

    @ExcelProperty("创建的用户id")
    private String createId;

    @ExcelProperty("视频连接")
    private String videoUrl;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty(value = "专家建议")
    private String expertAdvice;

    @ExcelProperty("创建时间")
    private Date createTime;

}
