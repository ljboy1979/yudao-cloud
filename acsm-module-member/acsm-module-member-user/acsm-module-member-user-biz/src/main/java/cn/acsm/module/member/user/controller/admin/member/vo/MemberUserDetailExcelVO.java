package cn.acsm.module.member.user.controller.admin.member.vo;

import cn.acsm.module.member.user.enums.DictTypeConstants;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
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

    @ExcelProperty("企业账号")
    private String memberAccount;

    @ExcelProperty("企业id")
    private Long enterpriseId;

    @ExcelProperty("企业名称")
    private String enterpriseName;

    @ExcelProperty("会员类型")
    @DictFormat(DictTypeConstants.MEMBER_TYPE)
    private Integer memberType;

    @ExcelProperty("会员角色")
    @DictFormat(DictTypeConstants.MEMBER_ROLE)
    private Integer memberRole;

    @ExcelProperty("会员等级id")
    private Long integralLevelId;

    @ExcelProperty("审核状态")
    @DictFormat(DictTypeConstants.MEMBER_AUDIT_STATUS)
    private Integer auditStatus;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
