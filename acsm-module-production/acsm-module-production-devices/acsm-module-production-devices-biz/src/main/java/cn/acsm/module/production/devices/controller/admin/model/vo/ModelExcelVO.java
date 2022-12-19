package cn.acsm.module.production.devices.controller.admin.model.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 设备型号 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ModelExcelVO {

    @ExcelProperty("主键")
    private Long id;

    @ExcelProperty("厂家")
    private String manufacturerId;

    @ExcelProperty("型号")
    private String name;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
