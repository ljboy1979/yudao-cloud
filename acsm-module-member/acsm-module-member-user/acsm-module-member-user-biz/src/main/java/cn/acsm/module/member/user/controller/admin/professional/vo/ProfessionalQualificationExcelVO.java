package cn.acsm.module.member.user.controller.admin.professional.vo;

import cn.acsm.module.member.user.enums.DictTypeConstants;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
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

    @ExcelProperty(value = "备案类型", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MEMBER_RECORD_TYPE)
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

    @ExcelProperty(value = "审核状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MEMBER_AUDIT_STATUS)
    private Integer auditStatus;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
