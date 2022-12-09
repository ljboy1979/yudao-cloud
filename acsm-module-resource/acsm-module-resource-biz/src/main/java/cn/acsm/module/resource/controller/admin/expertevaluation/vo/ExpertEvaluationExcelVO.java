package cn.acsm.module.resource.controller.admin.expertevaluation.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 健康状况 Excel VO
 *
 * @author smile
 */
@Data
public class ExpertEvaluationExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("评估人")
    private String evaluationPerson;

    @ExcelProperty("异常项")
    private String exceptionItem;

    @ExcelProperty("评估时间")
    private Date evaluationTime;

    @ExcelProperty("评估结果")
    private String evaluationResult;

    @ExcelProperty("关联认养物/租凭物")
    private String adoptContentId;

    @ExcelProperty("行为")
    private String behavior;

    @ExcelProperty("被毛")
    private String coat;

    @ExcelProperty("食欲")
    private String appetite;

    @ExcelProperty("牙齿")
    private String teeth;

    @ExcelProperty("眼睛")
    private String eyes;

    @ExcelProperty("鼻部")
    private String nose;

    @ExcelProperty("躯干")
    private String trunk;

    @ExcelProperty("排便")
    private String defecation;

    @ExcelProperty("体温")
    private String temperature;

    @ExcelProperty("心跳")
    private String heartbeat;

    @ExcelProperty("呼吸")
    private String breathing;

    @ExcelProperty("体重")
    private String weight;

    @ExcelProperty("行为异常介绍")
    private String behaviorContent;

    @ExcelProperty("被毛异常介绍")
    private String coatContent;

    @ExcelProperty("食欲异常介绍")
    private String appetiteContent;

    @ExcelProperty("牙齿异常介绍")
    private String teethContent;

    @ExcelProperty("眼睛异常介绍")
    private String eyesContent;

    @ExcelProperty("鼻部异常介绍")
    private String noseContent;

    @ExcelProperty("躯干异常介绍")
    private String trunkContent;

    @ExcelProperty("排便异常介绍")
    private String defecationContent;

    @ExcelProperty("体温异常介绍")
    private String temperatureContent;

    @ExcelProperty("心跳异常介绍")
    private String heartbeatContent;

    @ExcelProperty("呼吸异常介绍")
    private String breathingContent;

    @ExcelProperty("体重异常介绍")
    private String weightContent;

    @ExcelProperty("类型 type=1体检记录；type=0专家评估")
    private String type;

    @ExcelProperty("排尿")
    private String micturition;

    @ExcelProperty("排尿异常介绍")
    private String micturitionContent;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("项目来源")
    private String source;

    @ExcelProperty("经营主体id")
    private String subjectId;

}
