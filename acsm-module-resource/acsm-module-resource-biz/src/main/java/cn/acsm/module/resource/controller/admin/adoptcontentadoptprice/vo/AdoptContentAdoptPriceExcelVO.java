package cn.acsm.module.resource.controller.admin.adoptcontentadoptprice.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 认养/租凭价格 Excel VO
 *
 * @author smile
 */
@Data
public class AdoptContentAdoptPriceExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("认养物的id")
    private String adoptId;

    @ExcelProperty("认养物的名称")
    private String adoptName;

    @ExcelProperty("开始时间")
    private Date startTime;

    @ExcelProperty("结束时间")
    private Date endTime;

    @ExcelProperty("认养费用")
    private BigDecimal adoptPriceFee;

    @ExcelProperty("费用类型")
    private String feeType;

    @ExcelProperty("认养人标签")
    private String adoptPersonFlag;

    @ExcelProperty("权益价格的id")
    private String adoptRightId;

    @ExcelProperty("付款人数")
    private String payNum;

    @ExcelProperty("认养总数")
    private String adoptTotal;

    @ExcelProperty("认养剩余名额")
    private String adoptQuota;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("项目来源")
    private String source;

    @ExcelProperty("经营主体id")
    private String subjectId;

}
