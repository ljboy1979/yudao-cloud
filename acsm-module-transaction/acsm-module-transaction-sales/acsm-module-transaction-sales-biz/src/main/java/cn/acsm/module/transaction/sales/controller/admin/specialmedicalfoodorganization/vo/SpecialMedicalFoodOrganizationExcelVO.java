package cn.acsm.module.transaction.sales.controller.admin.specialmedicalfoodorganization.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 特医食品组成 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class SpecialMedicalFoodOrganizationExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("特医食品id")
    private String foodId;

    @ExcelProperty("组成编号")
    private String organizationNumber;

    @ExcelProperty("组成名称")
    private String organizationName;

    @ExcelProperty("产地")
    private String origin;

    @ExcelProperty("采购价")
    private BigDecimal purchasePrice;

    @ExcelProperty("图片路径")
    private String imgUrl;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体id")
    private String subjectId;

    @ExcelProperty("source")
    private String source;

}
