package cn.acsm.module.service.controller.admin.ticketdetail.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 套票详情 Excel VO
 *
 * @author smile
 */
@Data
public class TicketDetailExcelVO {

    @ExcelProperty("套票编号")
    private Long id;

    @ExcelProperty("套票id")
    private String ticketId;

    @ExcelProperty("商品id")
    private String skuId;

    @ExcelProperty("每次兑换数量")
    private Integer useNumber;

    @ExcelProperty("兑换频次 0 年 1月 ")
    private Integer useRate;

    @ExcelProperty("备注")
    private String remarks;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("项目来源")
    private String source;

}
