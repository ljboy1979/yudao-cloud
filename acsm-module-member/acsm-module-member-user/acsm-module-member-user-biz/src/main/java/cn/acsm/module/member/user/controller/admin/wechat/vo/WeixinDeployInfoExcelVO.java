package cn.acsm.module.member.user.controller.admin.wechat.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 微信公众号配置信息 Excel VO
 *
 * @author lihongyan
 */
@Data
public class WeixinDeployInfoExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("公众号appId")
    private String appid;

    @ExcelProperty("公众号appSecret")
    private String appsecret;

    @ExcelProperty("商户号")
    private String mchId;

    @ExcelProperty("商户密钥key")
    private String mchKey;

    @ExcelProperty("标识")
    private String appletFlag;

    @ExcelProperty("备注信息")
    private String remark;

    @ExcelProperty("状态（0正常 1停用）")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

}
