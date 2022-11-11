package cn.acsm.module.member.user.controller.admin.memberuserinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 用户基本信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class MemberUserInfoBaseVO {

    @ApiModelProperty(value = "用户表id")
    private String memberUserId;

    @ApiModelProperty(value = "用户账号", required = true)
    @NotNull(message = "用户账号不能为空")
    private String username;

    @ApiModelProperty(value = "用户昵称", required = true)
    @NotNull(message = "用户昵称不能为空")
    private String nickname;

    @ApiModelProperty(value = "住院号")
    private String inpatientNumber;

    @ApiModelProperty(value = "体重")
    private String weight;

    @ApiModelProperty(value = "身高")
    private String height;

    @ApiModelProperty(value = "关联饮食医嘱表")
    private String medicalAdviceId;

    @ApiModelProperty(value = "床位号")
    private String bedNumber;

    @ApiModelProperty(value = "紧急联系人")
    private String emergencyContact;

    @ApiModelProperty(value = "紧急联系电话")
    private String emergencyPhone;

    @ApiModelProperty(value = "订餐用户类型 0，普通用户 1，医生")
    private String type;

    @ApiModelProperty(value = "工卡卡号")
    private String account;

    @ApiModelProperty(value = "科室")
    private String department;

    @ApiModelProperty(value = "分区")
    private String partition;

    @ApiModelProperty(value = "楼号")
    private String building;

    @ApiModelProperty(value = "楼层")
    private String floor;

    @ApiModelProperty(value = "房间号")
    private String room;

    @ApiModelProperty(value = "身份证号")
    private String cardNum;

    @ApiModelProperty(value = "性别(0女，1男)")
    private String sex;

    @ApiModelProperty(value = "年龄")
    private String age;

    @ApiModelProperty(value = "一屋一码主键ID")
    private String mealsAppletQrcodeId;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "帐号状态（0正常 1停用）", required = true)
    @NotNull(message = "帐号状态（0正常 1停用）不能为空")
    private Integer status;

    @ApiModelProperty(value = "最后登录IP")
    private String loginIp;

    @ApiModelProperty(value = "最后登录时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date loginDate;

}
