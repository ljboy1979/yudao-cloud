package cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 服务资源-认养物/租凭物就医记录 Excel 导出 Request VO", description = "参数和 AdoptContentHealthPageReqVO 是一致的")
@Data
public class AdoptContentHealthExportReqVO {

    @ApiModelProperty(value = "关联认养物/租凭物")
    private String adoptContentId;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "评估时间")
    private Date assessment;

    @ApiModelProperty(value = "评估人")
    private String assessmenter;

    @ApiModelProperty(value = "评估结果")
    private String assessmentResult;

    @ApiModelProperty(value = "简要概述")
    private String description;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "项目来源")
    private String source;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

}
