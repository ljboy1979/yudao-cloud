package cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo;

import lombok.*;

import com.alibaba.excel.annotation.ExcelProperty;

import java.time.LocalDateTime;

/**
 * 经营主体其他账户 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class OtherAccountInfoExcelVO {

    @ExcelProperty("编号")
    private Long id;

//    @ExcelProperty("经营主体ID")
//    private Long enterpriseId;

    @ExcelProperty("账户名")
    private String accountName;

    @ExcelProperty("账户银行卡号")
    private String accountNo;

    @ExcelProperty("账户身份证号")
    private String accountIdCard;

    @ExcelProperty("账户开户行")
    private String accountBank;
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
    @ExcelProperty("更新时间")
    private LocalDateTime updateTime;
}
