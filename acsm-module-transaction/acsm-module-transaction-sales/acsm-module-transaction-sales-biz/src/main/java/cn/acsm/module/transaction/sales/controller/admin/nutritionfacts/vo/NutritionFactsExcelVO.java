package cn.acsm.module.transaction.sales.controller.admin.nutritionfacts.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 营养成分 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class NutritionFactsExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("类型（0菜品、1套餐、2特医食品）")
    private String type;

    @ExcelProperty("来源id（菜品、套餐、特医食品）")
    private String sourceId;

    @ExcelProperty("编号")
    private String number;

    @ExcelProperty("营养成分(字典id)")
    private String nutritionFacts;

    @ExcelProperty("营养成分名称")
    private String nutritionFactsName;

    @ExcelProperty("含量")
    private String content;

    @ExcelProperty("单位(字典id)")
    private String unit;

    @ExcelProperty("单位名称")
    private String unitName;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体id")
    private String subjectId;

    @ExcelProperty("source")
    private String source;

}
