package cn.acsm.module.enterprise.controller.admin.baseinfo.vo;

import cn.acsm.module.enterprise.enums.DictTypeConstants;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.*;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * 经营主体 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class BaseInfoExcelVO {

//    @ExcelProperty("主键ID")
//    private Long id;

    @ExcelProperty("主体编号")
    private String code;

    @ExcelProperty("主体名称")
    private String name;

    @ExcelProperty(value = "主体类型", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.ENTERPRISE_TYPE)
    private String enterpriseType;

//    @ExcelProperty("主体类型名称")
//    private String enterpriseTypeName;

    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.ENTERPRISE_STATUS)
    private String stauts;

    @ExcelProperty(value = "产业角色", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.USER_TAG)
    private String userTag;

//    @ExcelProperty("产业角色名称")
//    private String userTagName;

//    @ExcelProperty(value = "经营状态", converter = DictConvert.class)
//    @DictFormat("manage_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
//    private String manageStatus;

    @ExcelProperty("注册时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerTime;

//    @ExcelProperty("联系人")
//    private String contactName;

    @ExcelProperty("联系人电话")
    private String contactPhone;

//    @ExcelProperty("省id")
//    private String villagesAreaId;
//
//    @ExcelProperty("省名称")
//    private String villagesAreaName;
//
//    @ExcelProperty("市id")
//    private String areaId;
//
//    @ExcelProperty("市名称")
//    private String areaName;
//
//    @ExcelProperty("区id")
//    private String ruralId;
//
//    @ExcelProperty("区名称")
//    private String ruralName;

}
