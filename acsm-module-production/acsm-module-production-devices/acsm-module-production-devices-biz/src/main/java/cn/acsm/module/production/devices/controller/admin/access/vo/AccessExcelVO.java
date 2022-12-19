package cn.acsm.module.production.devices.controller.admin.access.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 设备允许访问名单信息 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class AccessExcelVO {

    @ExcelProperty("主键")
    private Long id;

    @ExcelProperty("设备id")
    private String deviceId;

    @ExcelProperty("手机号")
    private String accessPhone;

    @ExcelProperty("访问方式")
    private String accessWay;

    @ExcelProperty("时间")
    private Date insertTime;

    @ExcelProperty("备注信息")
    private String remarks;

    @ExcelProperty("审核状态")
    private String reviewStatus;

    @ExcelProperty("审核人")
    private String reviewer;

    @ExcelProperty("审核时间")
    private Date reviewDate;

    @ExcelProperty("审核内容")
    private String reviewContent;

    @ExcelProperty("机构编码")
    private String officeCode;

    @ExcelProperty("机构名称")
    private String officeName;

    @ExcelProperty("公司编码")
    private String companyCode;

    @ExcelProperty("公司名称")
    private String companyName;

    @ExcelProperty("租户代码")
    private String corpCode;

    @ExcelProperty("租户名称")
    private String corpName;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
