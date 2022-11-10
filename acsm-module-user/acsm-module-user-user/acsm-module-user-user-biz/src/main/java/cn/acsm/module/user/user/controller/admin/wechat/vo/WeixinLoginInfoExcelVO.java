package cn.acsm.module.user.user.controller.admin.wechat.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 微信登录信息记录 Excel VO
 *
 * @author lihongyan
 */
@Data
public class WeixinLoginInfoExcelVO {

    @ExcelProperty("用基本信息表ID")
    private Long id;

    @ExcelProperty("openid")
    private String openid;

    @ExcelProperty("用户手机号")
    private String phone;

    @ExcelProperty("系统的user_id")
    private String systemUserId;

    @ExcelProperty("用户头像地址")
    private String avatar;

    @ExcelProperty("省份名称")
    private String province;

    @ExcelProperty("市名称")
    private String city;

    @ExcelProperty("用户昵称")
    private String nickName;

    @ExcelProperty("性别(0女，1男)")
    private String sex;

    @ExcelProperty("类型 1-微信")
    private String type;

    @ExcelProperty("状态（0正常 1停用）")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

}
