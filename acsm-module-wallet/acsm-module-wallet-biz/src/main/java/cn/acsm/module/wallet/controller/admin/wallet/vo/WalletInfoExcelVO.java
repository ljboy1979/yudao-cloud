package cn.acsm.module.wallet.controller.admin.wallet.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 钱包信息 Excel VO
 *
 * @author lihongyan
 */
@Data
public class WalletInfoExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("钱包编号")
    private String walletNo;

    @ExcelProperty("会员id")
    private String memberId;

    @ExcelProperty("用户名")
    private String username;

    @ExcelProperty("手机号")
    private String phone;

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
