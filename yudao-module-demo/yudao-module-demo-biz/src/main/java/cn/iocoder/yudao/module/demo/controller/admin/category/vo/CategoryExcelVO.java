package cn.iocoder.yudao.module.demo.controller.admin.category.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 商品分类 Excel VO
 *
 * @author liuj
 */
@Data
public class CategoryExcelVO {

    @ExcelProperty("分类id")
    private Long id;

    @ExcelProperty("上级分类的编号：0表示一级分类")
    private Long parentId;

    @ExcelProperty("名称")
    private String name;

    @ExcelProperty("分类级别：0->1级；1->2级")
    private Boolean level;

    @ExcelProperty("显示状态：0->不显示；1->显示")
    private Boolean showStatus;

    @ExcelProperty("排序")
    private Integer sort;

    @ExcelProperty("图标")
    private String icon;

    @ExcelProperty("描述")
    private String description;

}
