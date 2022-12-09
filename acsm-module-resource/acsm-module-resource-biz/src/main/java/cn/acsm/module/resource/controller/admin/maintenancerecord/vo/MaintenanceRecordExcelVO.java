package cn.acsm.module.resource.controller.admin.maintenancerecord.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 服务资源-养护记录 Excel VO
 *
 * @author smile
 */
@Data
public class MaintenanceRecordExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("关联认养物/租凭物")
    private String serviceAdoptContentId;

    @ExcelProperty("养护人")
    private String maintenanceName;

    @ExcelProperty("内容")
    private String content;

    @ExcelProperty("开始时间")
    private Date beginTime;

    @ExcelProperty("结束时间")
    private Date endTime;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("项目来源")
    private String source;

    @ExcelProperty("经营主体id")
    private String subjectId;

}
