package cn.acsm.module.member.user.controller.admin.member.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 会员信息 Excel VO
 *
 * @author lihongyan
 */
@Data
public class MemberUserDetailExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("会员id")
    private Long memberId;

    @ExcelProperty("企业id")
    private Long enterpriseId;

    @ExcelProperty("企业名称")
    private String enterpriseName;

    @ExcelProperty("会员类型")
    private Integer memberType;

    @ExcelProperty("会员角色")
    private Integer memberRole;

    @ExcelProperty("会员等级id")
    private Long integralLevelId;

    @ExcelProperty("审核状态")
    private Integer auditStatus;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
