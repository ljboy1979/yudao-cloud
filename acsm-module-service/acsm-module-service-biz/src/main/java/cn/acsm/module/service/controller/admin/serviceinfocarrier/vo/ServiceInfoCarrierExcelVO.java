package cn.acsm.module.service.controller.admin.serviceinfocarrier.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 服务-认养物/租凭物 Excel VO
 *
 * @author smile
 */
@Data
public class ServiceInfoCarrierExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("认养物/租凭物的id")
    private String adoptContentAdoptId;

    @ExcelProperty("服务的id")
    private String serviceInfoId;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("项目来源")
    private String source;

}
