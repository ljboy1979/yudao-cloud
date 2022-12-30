package cn.acsm.module.production.facility.controller.admin.cargospace.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 设施货位 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class CargoSpaceExcelVO {

    @ExcelProperty("主键")
    private Long id;

    @ExcelProperty("货位号")
    private String spaceCode;

    @ExcelProperty("行数")
    private Integer spaceRowNumber;

    @ExcelProperty("列数")
    private Integer spaceColumnNumber;

    @ExcelProperty("层数")
    private Integer spaceLayerNumber;

    @ExcelProperty("设施")
    private Integer facilityId;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
