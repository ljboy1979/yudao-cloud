package cn.acsm.module.transaction.pricetag.controller.admin.marketclassify.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 市场分类 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class MarketClassifyExcelVO {


    @ExcelProperty("分类名称")
    private String categoryName;


    @ExcelProperty("分类全路径")
    private String treeNames;


    @ExcelProperty("创建时间")
    private Date createTime;


}
