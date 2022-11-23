package cn.acsm.module.enterprise.controller.admin.baseinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 经营主体创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BaseInfoCreateReqVO extends BaseInfoBaseVO {

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

    @ApiModelProperty(value = "联系人电话")
    private String contactPhone;

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
