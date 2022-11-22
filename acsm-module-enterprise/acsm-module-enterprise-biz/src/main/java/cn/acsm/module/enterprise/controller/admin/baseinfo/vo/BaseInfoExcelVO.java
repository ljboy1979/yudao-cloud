package cn.acsm.module.enterprise.controller.admin.baseinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 经营主体 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class BaseInfoExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("主体编号")
    private String code;

    @ExcelProperty("主体名称")
    private String name;

    @ExcelProperty("主体类型：下拉列表，包含个体、企业、合作社、有限责任公司、股份有限公司")
    private String enterpriseType;

    @ExcelProperty("主体类型名称")
    private String enterpriseTypeName;

    @ExcelProperty("状态")
    private String stauts;

    @ExcelProperty("产业角色")
    private String userTag;

    @ExcelProperty("产业角色名称")
    private String userTagName;

    @ExcelProperty("经营状态：下拉列表，包含存续、在业、吊销、注销、迁入、迁出、停业、清算")
    private String manageStatus;

    @ExcelProperty("注册地址")
    private String address;

    @ExcelProperty("详细地址")
    private String detailedAddress;

    @ExcelProperty("统一社会信用代码或注册号")
    private String socialCreditCode;

    @ExcelProperty("电子营业执照")
    private String businessCertificatePhoto;

    @ExcelProperty("法定代表人")
    private String legalPerson;

    @ExcelProperty("法人身份证")
    private String legalIdCard;

    @ExcelProperty("法人身份证照片")
    private String legalIdCardPhoto;

    @ExcelProperty("注册时间")
    private Date registerTime;

    @ExcelProperty("公司简介")
    private String description;

    @ExcelProperty("企业LOGO")
    private String logo;

    @ExcelProperty("经营许可证号")
    private String businessLicenseNo;

    @ExcelProperty("生产/经营许可证图片")
    private String businessLicensePhoto;

    @ExcelProperty("证件截止日期")
    private Date businessLicenseEndTime;

    @ExcelProperty("账户名")
    private String accountName;

    @ExcelProperty("账户银行卡号")
    private String accountNo;

    @ExcelProperty("账户身份证号")
    private String accountIdCard;

    @ExcelProperty("账户开户行")
    private String accountBank;

    @ExcelProperty("联系人")
    private String contactName;

    @ExcelProperty("联系人电话")
    private String contactPhone;

    @ExcelProperty("省id")
    private String villagesAreaId;

    @ExcelProperty("省名称")
    private String villagesAreaName;

    @ExcelProperty("市id")
    private String areaId;

    @ExcelProperty("市名称")
    private String areaName;

    @ExcelProperty("区id")
    private String ruralId;

    @ExcelProperty("区名称")
    private String ruralName;

    @ExcelProperty("企业规模")
    private String enterpriseScale;

    @ExcelProperty("主营业务")
    private String serviceRange;

    @ExcelProperty("备注")
    private String remarks;

    @ExcelProperty("租户集合")
    private Long source;

    @ExcelProperty("经营主体ID")
    private Long subjectId;

    @ExcelProperty("创建时间")
    private Date createTime;

}
