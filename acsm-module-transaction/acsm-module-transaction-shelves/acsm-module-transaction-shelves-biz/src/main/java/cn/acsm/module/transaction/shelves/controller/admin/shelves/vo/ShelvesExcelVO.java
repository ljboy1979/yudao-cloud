package cn.acsm.module.transaction.shelves.controller.admin.shelves.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;

import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 货架 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ShelvesExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("名称")
    private String name;

    @ExcelProperty("分类id")
    private String classifyId;

    @ExcelProperty("来源id")
    private String sourceId;

    @ExcelProperty("货架编号")
    private String number;

    @ExcelProperty("售品类型 0原料、1投入品、2商品、3菜品、4套餐 5特医食品")
    private Integer type;

    @ExcelProperty("上架数量")
    private BigDecimal addNum;

    @ExcelProperty("可销售量")
    private BigDecimal availableNum;

    @ExcelProperty("销量")
    private BigDecimal salesNum;

    @ExcelProperty("计量单位")
    private String measurementUnit;

    @ExcelProperty("计量单位名称")
    private String measurementUnitName;

    @ExcelProperty("是否上架 0下架 1上架 2禁售")
    private String saleState;

    @ExcelProperty("供应日期")
    private Date supplyDate;

    @ExcelProperty("餐次 0早/1中/2晚")
    private Integer meals;

    @ExcelProperty("售品图片")
    private String imgUrl;

    @ExcelProperty("售品视频")
    private String videoUrl;

    @ExcelProperty("售品说明")
    private String explain;

    @ExcelProperty("标签")
    private String label;

    @ExcelProperty("排序")
    private Integer sort;

    @ExcelProperty("供应商")
    private String vendor;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体id")
    private String subjectId;

    @ExcelProperty("source")
    private String source;

}
