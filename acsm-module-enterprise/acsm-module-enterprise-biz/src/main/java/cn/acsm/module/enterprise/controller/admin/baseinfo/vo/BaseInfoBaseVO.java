package cn.acsm.module.enterprise.controller.admin.baseinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 经营主体 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class BaseInfoBaseVO {

    @ApiModelProperty(value = "主体编号")
    private String code;

    @ApiModelProperty(value = "主体名称")
    private String name;

    @ApiModelProperty(value = "主体类型：下拉列表，包含个体、企业、合作社、有限责任公司、股份有限公司")
    private String enterpriseType;

    @ApiModelProperty(value = "主体类型名称")
    private String enterpriseTypeName;

    @ApiModelProperty(value = "状态")
    private String stauts;

    @ApiModelProperty(value = "产业角色")
    private String userTag;

    @ApiModelProperty(value = "产业角色名称")
    private String userTagName;

    @ApiModelProperty(value = "经营状态：下拉列表，包含存续、在业、吊销、注销、迁入、迁出、停业、清算", required = true)
    @NotNull(message = "经营状态：下拉列表，包含存续、在业、吊销、注销、迁入、迁出、停业、清算不能为空")
    private String manageStatus;

    @ApiModelProperty(value = "注册地址")
    private String address;

    @ApiModelProperty(value = "详细地址")
    private String detailedAddress;

    @ApiModelProperty(value = "统一社会信用代码或注册号")
    private String socialCreditCode;

    @ApiModelProperty(value = "电子营业执照")
    private String businessCertificatePhoto;

    @ApiModelProperty(value = "法定代表人")
    private String legalPerson;

    @ApiModelProperty(value = "法人身份证")
    private String legalIdCard;

    @ApiModelProperty(value = "法人身份证照片")
    private String legalIdCardPhoto;

    @ApiModelProperty(value = "注册时间")
    private Date registerTime;

    @ApiModelProperty(value = "公司简介")
    private String description;

    @ApiModelProperty(value = "企业LOGO")
    private String logo;

    @ApiModelProperty(value = "经营许可证号")
    private String businessLicenseNo;

    @ApiModelProperty(value = "生产/经营许可证图片")
    private String businessLicensePhoto;

    @ApiModelProperty(value = "证件截止日期")
    private Date businessLicenseEndTime;

    @ApiModelProperty(value = "账户名")
    private String accountName;

    @ApiModelProperty(value = "账户银行卡号")
    private String accountNo;

    @ApiModelProperty(value = "账户身份证号")
    private String accountIdCard;

    @ApiModelProperty(value = "账户开户行")
    private String accountBank;

    @ApiModelProperty(value = "联系人")
    private String contactName;

    @ApiModelProperty(value = "联系人电话")
    private String contactPhone;

    @ApiModelProperty(value = "省id")
    private String villagesAreaId;

    @ApiModelProperty(value = "省名称")
    private String villagesAreaName;

    @ApiModelProperty(value = "市id")
    private String areaId;

    @ApiModelProperty(value = "市名称")
    private String areaName;

    @ApiModelProperty(value = "区id")
    private String ruralId;

    @ApiModelProperty(value = "区名称")
    private String ruralName;

    @ApiModelProperty(value = "企业规模")
    private String enterpriseScale;

    @ApiModelProperty(value = "主营业务")
    private String serviceRange;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
