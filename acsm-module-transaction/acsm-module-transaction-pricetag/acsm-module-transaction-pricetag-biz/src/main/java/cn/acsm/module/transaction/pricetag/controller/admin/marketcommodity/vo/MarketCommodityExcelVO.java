package cn.acsm.module.transaction.pricetag.controller.admin.marketcommodity.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 市场商品 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class MarketCommodityExcelVO {




    @ExcelProperty("商品编号")
    private String commodityCode;

    @ExcelProperty("商品名称")
    private String commodityName;


    @ExcelProperty("规格名称")
    private String specificationsName;


    @ExcelProperty("包装类型名称")
    private String packagingTypeName;

    @ExcelProperty("规格数量")
    private String number;


    @ExcelProperty("单位名称")
    private String unitName;


    @ExcelProperty("包装单位名称")
    private String packagingName;


    @ExcelProperty("计量单位名称")
    private String measurementUnitName;

    @ExcelProperty("产地")
    private String productionAddress;

    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;


}
