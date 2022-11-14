package cn.acsm.module.member.user.controller.app.member.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 用户 Excel VO
 *
 * @author lihongyan
 */
@Data
public class AppMemberUserExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("用户昵称")
    private String nickname;

    @ExcelProperty("头像")
    private String avatar;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("手机号")
    private String mobile;

    @ExcelProperty("密码")
    private String password;

    @ExcelProperty("注册 IP")
    private String registerIp;

    @ExcelProperty("最后登录IP")
    private String loginIp;

    @ExcelProperty("最后登录时间")
    private Date loginDate;

    @ExcelProperty("创建时间")
    private Date createTime;

}
