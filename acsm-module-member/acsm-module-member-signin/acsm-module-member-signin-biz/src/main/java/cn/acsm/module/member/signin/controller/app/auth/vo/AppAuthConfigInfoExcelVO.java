package cn.acsm.module.member.signin.controller.app.auth.vo;

import lombok.*;
import java.util.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 会员登录授权配置信息 Excel VO
 *
 * @author lihongyan
 */
@Data
public class AppAuthConfigInfoExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("公众号appId")
    private String appId;

    @ExcelProperty("公众号appSecret")
    private String appSecret;

    @ExcelProperty("标识 1-微信")
    private String appletFlag;

    @ExcelProperty("备注信息")
    private String remark;

    @ExcelProperty("状态（0正常 1停用）")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

}
