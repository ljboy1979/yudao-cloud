package cn.acsm.module.production.facility.controller.admin.contract.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 租赁合同 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ContractBaseVO {

    @ApiModelProperty(value = "经营主体id")
    private String induSubjectId;

    @ApiModelProperty(value = "合同名称")
    private String contractName;

    @ApiModelProperty(value = "合同编号")
    private String contractNum;

    @ApiModelProperty(value = "合同简要内容")
    private String contractContent;

    @ApiModelProperty(value = "签订时间")
    private Date signTime;

    @ApiModelProperty(value = "签订方")
    private String signatory;

    @ApiModelProperty(value = "金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "机构编码")
    private String officeCode;

    @ApiModelProperty(value = "机构名称")
    private String officeName;

    @ApiModelProperty(value = "公司编码")
    private String companyCode;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "审核状态")
    private String reviewStatus;

    @ApiModelProperty(value = "审核人")
    private String reviewer;

    @ApiModelProperty(value = "审核时间")
    private Date reviewDate;

    @ApiModelProperty(value = "审核内容")
    private String reviewContent;

    @ApiModelProperty(value = "租户代码", required = true)
    @NotNull(message = "租户代码不能为空")
    private String corpCode;

    @ApiModelProperty(value = "租户名称", required = true)
    @NotNull(message = "租户名称不能为空")
    private String corpName;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
