package cn.acsm.module.stock.controller.admin.inventory.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 库存清单 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class StockInventoryExcelVO {

    @ExcelProperty("库存清单id")
    private String id;

    @ExcelProperty("库存类型(1.原料 2.投入品 3.成品 4.办公用品)")
    private Integer type;

    @ExcelProperty("仓库id")
    private String warehouseId;

    @ExcelProperty("仓库编号")
    private String warehouseCode;

    @ExcelProperty("仓库名称")
    private String warehouseName;

    @ExcelProperty("仓库类型")
    private Integer warehouseType;

    @ExcelProperty("货品id")
    private String goodsId;

    @ExcelProperty("货品编号")
    private String goodsNumber;

    @ExcelProperty("货品名称")
    private String goodsName;

    @ExcelProperty("货品类型")
    private String goodsType;

    @ExcelProperty("包装类型")
    private String packagingType;

    @ExcelProperty("包装规格id")
    private String packagingSpecificationId;

    @ExcelProperty("包装规格")
    private String packingSpecification;

    @ExcelProperty("库存数量")
    private Integer inventoryQuantity;

    @ExcelProperty("计量单位")
    private String measureUnit;

    @ExcelProperty("预警数量上线")
    private Integer upperWarningLimit;

    @ExcelProperty("预警数量下线")
    private Integer lowerWarningLimit;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体")
    private String subjectId;

    @ExcelProperty("用户id")
    private Long userId;

    @ExcelProperty("租户集合")
    private Long sourceId;

}
