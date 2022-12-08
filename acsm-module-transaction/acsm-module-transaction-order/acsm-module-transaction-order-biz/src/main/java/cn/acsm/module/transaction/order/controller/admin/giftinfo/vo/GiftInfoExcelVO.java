package cn.acsm.module.transaction.order.controller.admin.giftinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 赠品 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class GiftInfoExcelVO {

    @ExcelProperty("赠品id")
    private Integer id;

    @ExcelProperty("赠品编号")
    private String giftNumber;

    @ExcelProperty("货品id")
    private String goodsId;

    @ExcelProperty("赠品名称(套餐id)")
    private String giftName;

    @ExcelProperty("数量")
    private String giftAmount;

    @ExcelProperty("订单id")
    private String skuPackageOrderId;

    @ExcelProperty("分类id")
    private String classifyId;

    @ExcelProperty("分类名称")
    private String classifyName;

    @ExcelProperty("计量单位")
    private String unit;

    @ExcelProperty("计量单位名称")
    private String unitName;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体id")
    private String subjectId;

    @ExcelProperty("source")
    private String source;

}
