package cn.acsm.module.transaction.pricetag.controller.admin.scheduledprice.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 预定价格 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ScheduledPriceExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("分类id")
    private String classifyId;

    @ExcelProperty("商品编号")
    private String commodityCode;

    @ExcelProperty("商品名称")
    private String commodityName;

    @ExcelProperty("市场id")
    private String marketId;

    @ExcelProperty("规格名称")
    private String specificationsName;

    @ExcelProperty("包装类型(0定装1散装)")
    private String packagingType;

    @ExcelProperty("包装类型名称")
    private String packagingTypeName;

    @ExcelProperty("规格数量")
    private String number;

    @ExcelProperty("单位")
    private String unit;

    @ExcelProperty("单位名称")
    private String unitName;

    @ExcelProperty("包装单位")
    private String packaging;

    @ExcelProperty("包装单位名称")
    private String packagingName;

    @ExcelProperty("计量单位")
    private String measurementUnit;

    @ExcelProperty("计量单位名称")
    private String measurementUnitName;

    @ExcelProperty("不包邮预定价")
    private BigDecimal freeShippingPrice;

    @ExcelProperty("包邮预定价")
    private BigDecimal shippingPrice;

    @ExcelProperty("有效期")
    private Date expirationDate;

    @ExcelProperty("来源")
    private String source;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体id")
    private String subjectId;

}
