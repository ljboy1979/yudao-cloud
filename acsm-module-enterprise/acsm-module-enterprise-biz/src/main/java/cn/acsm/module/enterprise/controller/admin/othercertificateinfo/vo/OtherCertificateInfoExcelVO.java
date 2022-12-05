package cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 经营主体其他证件 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class OtherCertificateInfoExcelVO {

//    @ExcelProperty("编号")
//    private Long id;

//    @ExcelProperty("经营主体ID")
//    private Long enterpriseId;

    @ExcelProperty(value = "证件类型", converter = DictConvert.class)
    @DictFormat("certificate_type") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Integer certificateType;

    @ExcelProperty("证件名称")
    private String certificateName;

    @ExcelProperty("证件号")
    private String certificateNo;

    @ExcelProperty("证件截止日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date certificateEndTime;

//    @ExcelProperty("租户集合")
//    private Long source;

//    @ExcelProperty("经营主体ID")
//    private Long subjectId;
//
//    @ExcelProperty("创建者")
//    private String creator;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

//    @ExcelProperty("更新者")
//    private String updater;

    @ExcelProperty("更新时间")
    private LocalDateTime updateTime;

}
