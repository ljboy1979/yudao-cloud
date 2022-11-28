package cn.iocoder.yudao.module.transaction.sales.controller.admin.dishes.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 菜品 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class DishesExcelVO {

    @ExcelProperty("商品id")
    private String id;

    @ExcelProperty("菜品编号")
    private String ingredientNumber;

    @ExcelProperty("菜品名称")
    private String dishesName;

    @ExcelProperty("菜品分类")
    private String menuClassification;

    @ExcelProperty("菜系")
    private String cuisine;

    @ExcelProperty("烹饪方式")
    private Boolean cookingStyle;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体id")
    private String subjectId;

    @ExcelProperty("source")
    private String source;

}
