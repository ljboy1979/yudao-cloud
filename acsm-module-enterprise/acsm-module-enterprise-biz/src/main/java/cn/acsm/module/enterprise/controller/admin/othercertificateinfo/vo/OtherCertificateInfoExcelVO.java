package cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 经营主体其他证件 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class OtherCertificateInfoExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("经营主体ID")
    private Long enterpriseId;

    @ExcelProperty("证件类型")
    private Integer certificateType;

    @ExcelProperty("证件名称")
    private String certificateName;

    @ExcelProperty("证件号")
    private String certificateNo;

    @ExcelProperty("证件截止日期")
    private Date certificateEndTime;

    @ExcelProperty("证件照片")
    private String certificatePhoto;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

    @ExcelProperty("创建时间")
    private Date createTime;

}
