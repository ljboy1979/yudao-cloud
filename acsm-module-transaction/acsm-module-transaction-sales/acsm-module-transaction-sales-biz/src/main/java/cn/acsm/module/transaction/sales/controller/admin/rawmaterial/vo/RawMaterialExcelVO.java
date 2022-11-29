package cn.acsm.module.transaction.sales.controller.admin.rawmaterial.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 原料 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class RawMaterialExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("原料编号")
    private String ingredientNumber;

    @ExcelProperty("分类id")
    private String classify;

    @ExcelProperty("原料名称")
    private String name;

    @ExcelProperty("产地(字典值)")
    private String origin;

    @ExcelProperty("原料图片")
    private String imgUrl;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("专家建议")
    private String expertAdvice;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

}
