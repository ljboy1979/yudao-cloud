package cn.acsm.module.transaction.sales.controller.admin.commodityorganization.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 商品组成 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class CommodityOrganizationExcelVO {

    @ExcelProperty("id")
    private String id;

    @ExcelProperty("原料表id")
    private String rawMaterialId;

    @ExcelProperty("商品id")
    private String commodityId;

    @ExcelProperty("组成编号")
    private String organizationNumber;

    @ExcelProperty("组成名称")
    private String organizationName;

    @ExcelProperty("分类")
    private String classify;

    @ExcelProperty("产地")
    private String origin;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

}
