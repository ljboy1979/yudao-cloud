package cn.acsm.module.transaction.sales.controller.admin.specialmedicalfood.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 特医食品 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class SpecialMedicalFoodExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("特医食品编号")
    private String number;

    @ExcelProperty("特医食品名称")
    private String name;

    @ExcelProperty("特医食品分类id")
    private String classify;

    @ExcelProperty("特医食品图片")
    private String imgUrl;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("专家建议")
    private String expertAdvice;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体id")
    private String subjectId;

    @ExcelProperty("source")
    private String source;

}
