package cn.acsm.module.wallet.controller.admin.wallet.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 关联银行卡子 Excel VO
 *
 * @author lihongyan
 */
@Data
public class BankCardsInfoExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("会员id")
    private Long memberId;

    @ExcelProperty("钱包id")
    private Long walletId;

    @ExcelProperty("银行卡类型")
    private String bankCardType;

    @ExcelProperty("持卡人")
    private String cardholder;

    @ExcelProperty("卡号")
    private String cardNumber;

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
