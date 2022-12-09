package cn.acsm.module.resource.controller.admin.adoptcontenthealth.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 服务资源-认养物/租凭物就医记录 Excel VO
 *
 * @author smile
 */
@Data
public class AdoptContentHealthExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("关联认养物/租凭物")
    private String adoptContentId;

    @ExcelProperty("类型")
    private String type;

    @ExcelProperty("评估时间")
    private Date assessment;

    @ExcelProperty("评估人")
    private String assessmenter;

    @ExcelProperty("评估结果")
    private String assessmentResult;

    @ExcelProperty("简要概述")
    private String description;

    @ExcelProperty("公司名称")
    private String companyName;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("项目来源")
    private String source;

    @ExcelProperty("经营主体id")
    private String subjectId;

}
