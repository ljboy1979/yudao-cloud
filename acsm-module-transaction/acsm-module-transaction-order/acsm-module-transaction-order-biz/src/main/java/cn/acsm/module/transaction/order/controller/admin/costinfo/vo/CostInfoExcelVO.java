package cn.acsm.module.transaction.order.controller.admin.costinfo.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 费用 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class CostInfoExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("费用编号")
    private String costNumber;

    @ExcelProperty("费用类型（0-团长返利、1-误差退款、2-其他费用）")
    private String costType;

    @ExcelProperty("费用金额")
    private BigDecimal costAmount;

    @ExcelProperty("订单id")
    private String skuPackageOrderId;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("支付状态（0-待支付，1-已支付）")
    private String payStatus;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体id")
    private String subjectId;

    @ExcelProperty("source")
    private String source;

}
