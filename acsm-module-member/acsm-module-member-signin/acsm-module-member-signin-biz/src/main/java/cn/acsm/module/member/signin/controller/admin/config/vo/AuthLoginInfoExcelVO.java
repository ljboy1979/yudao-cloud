package cn.acsm.module.member.signin.controller.admin.config.vo;

import lombok.*;
import java.util.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 会员授权登录信息记录 Excel VO
 *
 * @author lihongyan
 */
@Data
public class AuthLoginInfoExcelVO {

    @ExcelProperty("用基本信息表ID")
    private Long id;

    @ExcelProperty("openid")
    private String openId;

    @ExcelProperty("用户手机号")
    private String phone;

    @ExcelProperty("会员id")
    private Long memberId;

    @ExcelProperty("性别(0女，1男)")
    private Integer sex;

    @ExcelProperty("类型 1-微信")
    private Integer type;

    @ExcelProperty("状态（0正常 1停用）")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
