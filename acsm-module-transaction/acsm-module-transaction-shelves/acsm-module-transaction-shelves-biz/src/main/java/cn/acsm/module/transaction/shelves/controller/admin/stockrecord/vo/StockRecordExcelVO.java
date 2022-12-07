package cn.acsm.module.transaction.shelves.controller.admin.stockrecord.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 货架库存记录 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class StockRecordExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("货架规格id")
    private String specificationsId;

    @ExcelProperty("类型 0 上架 1下架 2销售 3报损 4退货")
    private String type;

    @ExcelProperty("操作量")
    private BigDecimal amount;

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
