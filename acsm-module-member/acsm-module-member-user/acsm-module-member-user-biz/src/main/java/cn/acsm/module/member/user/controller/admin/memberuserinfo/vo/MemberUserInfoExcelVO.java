package cn.acsm.module.member.user.controller.admin.memberuserinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 用户基本信息 Excel VO
 *
 * @author lihongyan
 */
@Data
public class MemberUserInfoExcelVO {

    @ExcelProperty("用基本信息表ID")
    private Long id;

    @ExcelProperty("用户表id")
    private String memberUserId;

    @ExcelProperty("用户账号")
    private String username;

    @ExcelProperty("用户昵称")
    private String nickname;

    @ExcelProperty("住院号")
    private String inpatientNumber;

    @ExcelProperty("体重")
    private String weight;

    @ExcelProperty("身高")
    private String height;

    @ExcelProperty("关联饮食医嘱表")
    private String medicalAdviceId;

    @ExcelProperty("床位号")
    private String bedNumber;

    @ExcelProperty("紧急联系人")
    private String emergencyContact;

    @ExcelProperty("紧急联系电话")
    private String emergencyPhone;

    @ExcelProperty("订餐用户类型 0，普通用户 1，医生")
    private String type;

    @ExcelProperty("工卡卡号")
    private String account;

    @ExcelProperty("科室")
    private String department;

    @ExcelProperty("分区")
    private String partition;

    @ExcelProperty("楼号")
    private String building;

    @ExcelProperty("楼层")
    private String floor;

    @ExcelProperty("房间号")
    private String room;

    @ExcelProperty("身份证号")
    private String cardNum;

    @ExcelProperty("性别(0女，1男)")
    private String sex;

    @ExcelProperty("年龄")
    private String age;

    @ExcelProperty("一屋一码主键ID")
    private String mealsAppletQrcodeId;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("帐号状态（0正常 1停用）")
    private Integer status;

    @ExcelProperty("最后登录IP")
    private String loginIp;

    @ExcelProperty("最后登录时间")
    private Date loginDate;

    @ExcelProperty("创建时间")
    private Date createTime;

}
