package cn.acsm.module.stock.controller.admin.inventoryrecord.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 盘点记录 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class StockInventoryRecordExcelVO {

    @ExcelProperty("盘点记录id")
    private Long id;

    @ExcelProperty("库存类型(1.原料 2.投入品 3.成品 4.办公用品)")
    private Integer type;

    @ExcelProperty("仓库id")
    private String warehouseId;

    @ExcelProperty("仓库编号")
    private String warehouseCode;

    @ExcelProperty("仓库名称")
    private String warehouseName;

    @ExcelProperty("盘点批次")
    private String inventoryCode;

    @ExcelProperty("操作时间")
    private Date operationTime;

    @ExcelProperty("负责人id")
    private Long headId;

    @ExcelProperty("负责人名称")
    private String headName;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("经营主体")
    private String subjectId;

    @ExcelProperty("用户id")
    private Long userId;

    @ExcelProperty("租户集合")
    private Long sourceId;

}
