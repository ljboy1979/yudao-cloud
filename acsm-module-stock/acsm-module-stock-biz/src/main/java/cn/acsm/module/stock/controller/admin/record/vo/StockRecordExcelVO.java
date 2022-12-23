package cn.acsm.module.stock.controller.admin.record.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 库存记录 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class StockRecordExcelVO {

    @ExcelProperty("库存记录id")
    private Long id;

    @ExcelProperty("库存类型(1.原料 2.投入品 3.成品 4.办公用品)")
    private Integer type;

    @ExcelProperty("操作类型(0.入库 1.出库)")
    private Boolean operationType;

    @ExcelProperty("仓库id")
    private String warehouseId;

    @ExcelProperty("仓库编号")
    private String warehouseCode;

    @ExcelProperty("仓库名称")
    private String warehouseName;

    @ExcelProperty("批次号")
    private String batchNo;

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
