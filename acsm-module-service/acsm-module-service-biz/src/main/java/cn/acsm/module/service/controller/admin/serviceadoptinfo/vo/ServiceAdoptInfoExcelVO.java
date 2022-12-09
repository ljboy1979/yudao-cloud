package cn.acsm.module.service.controller.admin.serviceadoptinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 认养信息 Excel VO
 *
 * @author smile
 */
@Data
public class ServiceAdoptInfoExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("服务id")
    private String serviceId;

    @ExcelProperty("地块id")
    private String tunnelId;

    @ExcelProperty("认养物id")
    private String adoptId;

    @ExcelProperty("用户id")
    private String userId;

    @ExcelProperty("是否已认购 0未认购，1已认购")
    private String adoptStatus;

    @ExcelProperty("家庭成员id")
    private String familyId;

    @ExcelProperty("可种植作物")
    private String plantCropId;

    @ExcelProperty("可种植作物数量")
    private String plantCropNum;

    @ExcelProperty("基地id")
    private String basesId;

    @ExcelProperty("区域id")
    private String partitionsId;

    @ExcelProperty("载体id(关联认养物/租凭物)")
    private String carrierId;

    @ExcelProperty("可认购数量")
    private String applyNum;

    @ExcelProperty("已认购数量")
    private String applySubNum;

    @ExcelProperty("认养类型 0,菜田 1 牧场")
    private String adoptType;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("项目来源")
    private String source;

}
