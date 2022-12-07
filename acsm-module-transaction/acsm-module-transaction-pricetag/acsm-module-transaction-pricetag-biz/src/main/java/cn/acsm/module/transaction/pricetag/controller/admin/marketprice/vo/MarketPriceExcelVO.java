package cn.acsm.module.transaction.pricetag.controller.admin.marketprice.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 市场价格 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class MarketPriceExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("编码")
    private String code;

    @ExcelProperty("市场商品id")
    private String marketCommodityId;

    @ExcelProperty("最高价")
    private Float maxPrice;

    @ExcelProperty("最低价")
    private Float minPrice;

    @ExcelProperty("平均价")
    private Float middlePrice;

    @ExcelProperty("来源")
    private String source;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体id")
    private String subjectId;

}
