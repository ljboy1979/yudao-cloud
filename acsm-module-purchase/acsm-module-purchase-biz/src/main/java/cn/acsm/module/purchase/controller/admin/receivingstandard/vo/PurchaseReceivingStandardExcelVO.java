package cn.acsm.module.purchase.controller.admin.receivingstandard.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 收货标准 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PurchaseReceivingStandardExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("标准名称")
    private String name;

    @ExcelProperty("范围上限")
    private BigDecimal upperLimit;

    @ExcelProperty("范围下限")
    private BigDecimal lowerLimit;

    @ExcelProperty("单位(字典id)")
    private String unit;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体")
    private String subjectId;

}
