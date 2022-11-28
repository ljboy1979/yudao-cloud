package cn.iocoder.yudao.module.transaction.sales.controller.admin.dishesorganization.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 菜品组成 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class DishesOrganizationExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("原料表id")
    private String rawMaterialId;

    @ExcelProperty("菜品id")
    private String dishesId;

    @ExcelProperty("组成编号")
    private String organizationNumber;

    @ExcelProperty("组成名称")
    private String organizationName;

    @ExcelProperty("分类")
    private String classify;

    @ExcelProperty("产地")
    private String origin;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体id")
    private String subjectId;

    @ExcelProperty("source")
    private String source;

}
