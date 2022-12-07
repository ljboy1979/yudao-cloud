package cn.acsm.module.transaction.pricetag.controller.admin.marketpricedetails.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 市场价格明细 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class MarketPriceDetailsExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("市场价格id")
    private String marketPriceId;

    @ExcelProperty("价格编号")
    private String priceCode;

    @ExcelProperty("价格")
    private BigDecimal price;

    @ExcelProperty("支付人")
    private String payer;

    @ExcelProperty("0货架/1订单/2人工导入")
    private String priceSource;

    @ExcelProperty("来源")
    private String source;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体id")
    private String subjectId;

}
