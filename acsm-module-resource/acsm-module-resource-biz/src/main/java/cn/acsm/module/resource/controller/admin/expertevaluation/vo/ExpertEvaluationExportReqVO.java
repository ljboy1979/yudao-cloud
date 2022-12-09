package cn.acsm.module.resource.controller.admin.expertevaluation.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 健康状况 Excel 导出 Request VO", description = "参数和 ExpertEvaluationPageReqVO 是一致的")
@Data
public class ExpertEvaluationExportReqVO {

    @ApiModelProperty(value = "评估人")
    private String evaluationPerson;

    @ApiModelProperty(value = "异常项")
    private String exceptionItem;

    @ApiModelProperty(value = "评估时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] evaluationTime;

    @ApiModelProperty(value = "评估结果")
    private String evaluationResult;

    @ApiModelProperty(value = "关联认养物/租凭物")
    private String adoptContentId;

    @ApiModelProperty(value = "行为")
    private String behavior;

    @ApiModelProperty(value = "被毛")
    private String coat;

    @ApiModelProperty(value = "食欲")
    private String appetite;

    @ApiModelProperty(value = "牙齿")
    private String teeth;

    @ApiModelProperty(value = "眼睛")
    private String eyes;

    @ApiModelProperty(value = "鼻部")
    private String nose;

    @ApiModelProperty(value = "躯干")
    private String trunk;

    @ApiModelProperty(value = "排便")
    private String defecation;

    @ApiModelProperty(value = "体温")
    private String temperature;

    @ApiModelProperty(value = "心跳")
    private String heartbeat;

    @ApiModelProperty(value = "呼吸")
    private String breathing;

    @ApiModelProperty(value = "体重")
    private String weight;

    @ApiModelProperty(value = "行为异常介绍")
    private String behaviorContent;

    @ApiModelProperty(value = "被毛异常介绍")
    private String coatContent;

    @ApiModelProperty(value = "食欲异常介绍")
    private String appetiteContent;

    @ApiModelProperty(value = "牙齿异常介绍")
    private String teethContent;

    @ApiModelProperty(value = "眼睛异常介绍")
    private String eyesContent;

    @ApiModelProperty(value = "鼻部异常介绍")
    private String noseContent;

    @ApiModelProperty(value = "躯干异常介绍")
    private String trunkContent;

    @ApiModelProperty(value = "排便异常介绍")
    private String defecationContent;

    @ApiModelProperty(value = "体温异常介绍")
    private String temperatureContent;

    @ApiModelProperty(value = "心跳异常介绍")
    private String heartbeatContent;

    @ApiModelProperty(value = "呼吸异常介绍")
    private String breathingContent;

    @ApiModelProperty(value = "体重异常介绍")
    private String weightContent;

    @ApiModelProperty(value = "类型 type=1体检记录；type=0专家评估")
    private String type;

    @ApiModelProperty(value = "排尿")
    private String micturition;

    @ApiModelProperty(value = "排尿异常介绍")
    private String micturitionContent;

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
