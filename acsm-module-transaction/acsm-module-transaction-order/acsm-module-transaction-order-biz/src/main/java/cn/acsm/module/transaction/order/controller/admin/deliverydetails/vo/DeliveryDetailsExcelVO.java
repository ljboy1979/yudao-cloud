package cn.acsm.module.transaction.order.controller.admin.deliverydetails.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 配送详情 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class DeliveryDetailsExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("配送id")
    private String deliveryId;

    @ExcelProperty("编码")
    private String code;

    @ExcelProperty("名称")
    private String name;

    @ExcelProperty("规格名称")
    private String specificationName;

    @ExcelProperty("计量单位")
    private String unit;

    @ExcelProperty("数量")
    private String num;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体id")
    private String subjectId;

    @ExcelProperty("source")
    private String source;

}
