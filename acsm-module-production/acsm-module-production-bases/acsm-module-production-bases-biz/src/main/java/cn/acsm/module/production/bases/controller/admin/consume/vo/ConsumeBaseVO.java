package cn.acsm.module.production.bases.controller.admin.consume.vo;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 基地能耗信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ConsumeBaseVO {

    @ApiModelProperty(value = "基地id")
    private String basesId;

    @ApiModelProperty(value = "消耗量")
    private Double consumeNum;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "创建日期")
    private Date insertTime;

    @ApiModelProperty(value = "消耗类型1电2水3气")
    private String consumeType;

    @ApiModelProperty(value = "项目来源")
    private String source;

    @ApiModelProperty(value = "状态（0正常 1删除 2停用）", required = true)
    @NotNull(message = "状态（0正常 1删除 2停用）不能为空")
    private String status;

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

    @ApiModelProperty(value = "参数名称")
    private String paramName;

    @ApiModelProperty(value = "参数单位")
    private String paramUnit;

    @ApiModelProperty(value = "参数值")
    private BigDecimal num;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
