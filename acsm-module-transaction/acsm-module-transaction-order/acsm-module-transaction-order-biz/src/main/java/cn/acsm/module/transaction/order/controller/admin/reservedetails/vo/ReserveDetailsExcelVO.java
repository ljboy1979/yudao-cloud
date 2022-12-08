package cn.acsm.module.transaction.order.controller.admin.reservedetails.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 订单预定详情 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ReserveDetailsExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("预定id")
    private String reserveId;

    @ExcelProperty("商品名称")
    private String commodityName;

    @ExcelProperty("规格名称")
    private String specificationName;

    @ExcelProperty("购买数量")
    private String num;

    @ExcelProperty("市场价格")
    private String marketPrice;

    @ExcelProperty("经营主体id")
    private String subjectId;

    @ExcelProperty("套餐状态（默认 0未付款 1已取消 2已锁定）")
    private String planStatus;

    @ExcelProperty("价格")
    private BigDecimal price;

    @ExcelProperty("来源")
    private String source;

    @ExcelProperty("捕捞商品id")
    private String osCommodityFishingId;

    @ExcelProperty("捕捞规格id")
    private String productSpecificationsFishingId;

    @ExcelProperty("备注信息")
    private String remarks;

    @ExcelProperty("配送方式 0包邮 1不包邮")
    private String sendType;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

}
