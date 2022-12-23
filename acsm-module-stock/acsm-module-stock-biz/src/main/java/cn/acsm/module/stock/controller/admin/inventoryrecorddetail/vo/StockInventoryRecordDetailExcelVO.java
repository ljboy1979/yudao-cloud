package cn.acsm.module.stock.controller.admin.inventoryrecorddetail.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 盘点记录表子表-明细 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class StockInventoryRecordDetailExcelVO {

    @ExcelProperty("盘点记录明细id")
    private Long id;

    @ExcelProperty("库存记录id")
    private Long stockRecordId;

    @ExcelProperty("库存批次号")
    private String stockBatchNo;

    @ExcelProperty("库存记录明细id")
    private Long stockRecordDetailId;

    @ExcelProperty("库存类型(1.原料 2.投入品 3.成品 4.办公用品)")
    private Integer type;

    @ExcelProperty("二级分类(成品类：套餐/商品/特医食品)")
    private String secondaryClassification;

    @ExcelProperty("货品id")
    private String goodsId;

    @ExcelProperty("货品编号")
    private String goodsNumber;

    @ExcelProperty("货品名称")
    private String goodsName;

    @ExcelProperty("货品类型")
    private String goodsType;

    @ExcelProperty("包装规格id")
    private Long packagingSpecificationId;

    @ExcelProperty("包装规格")
    private String packagingSpecification;

    @ExcelProperty("包装规格名称")
    private String packagingSpecificationName;

    @ExcelProperty("包装类型")
    private String packagingType;

    @ExcelProperty("盘点前数量")
    private Integer inventoryFrontQuantity;

    @ExcelProperty("盘点后数量")
    private Integer inventoryAfterQuantity;

    @ExcelProperty("货位id")
    private Long goodsAllocationId;

    @ExcelProperty("货位号")
    private String goodsAllocationNo;

    @ExcelProperty("来源/去向说明")
    private String sourceTo;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体")
    private String subjectId;

    @ExcelProperty("用户id")
    private Long userId;

    @ExcelProperty("租户集合")
    private Long sourceId;

}
