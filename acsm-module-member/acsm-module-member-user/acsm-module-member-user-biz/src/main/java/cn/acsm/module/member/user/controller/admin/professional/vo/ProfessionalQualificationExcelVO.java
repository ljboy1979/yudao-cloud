package cn.acsm.module.member.user.controller.admin.professional.vo;

import lombok.*;

import java.time.LocalDateTime;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 专业资质 Excel VO
 *
 * @author lihongyan
 */
@Data
public class ProfessionalQualificationExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("会员id")
    private Long memberId;

    @ExcelProperty("备案类型")
    private String recordType;

    @ExcelProperty("备案名称")
    private String recordName;

    @ExcelProperty("许可证号码")
    private String permitNo;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("手机号")
    private String phone;

    @ExcelProperty("备案日期")
    private String recordDate;

    @ExcelProperty("证照")
    private String idPhoto;

    @ExcelProperty("审核状态")
    private Integer auditStatus;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
