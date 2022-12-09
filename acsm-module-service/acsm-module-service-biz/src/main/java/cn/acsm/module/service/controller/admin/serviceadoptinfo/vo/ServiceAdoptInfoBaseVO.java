package cn.acsm.module.service.controller.admin.serviceadoptinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 认养信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ServiceAdoptInfoBaseVO {

    @ApiModelProperty(value = "服务id")
    private String serviceId;

    @ApiModelProperty(value = "地块id")
    private String tunnelId;

    @ApiModelProperty(value = "认养物id")
    private String adoptId;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "是否已认购 0未认购，1已认购")
    private String adoptStatus;

    @ApiModelProperty(value = "家庭成员id")
    private String familyId;

    @ApiModelProperty(value = "可种植作物")
    private String plantCropId;

    @ApiModelProperty(value = "可种植作物数量")
    private String plantCropNum;

    @ApiModelProperty(value = "基地id")
    private String basesId;

    @ApiModelProperty(value = "区域id")
    private String partitionsId;

    @ApiModelProperty(value = "载体id(关联认养物/租凭物)")
    private String carrierId;

    @ApiModelProperty(value = "可认购数量")
    private String applyNum;

    @ApiModelProperty(value = "已认购数量")
    private String applySubNum;

    @ApiModelProperty(value = "认养类型 0,菜田 1 牧场")
    private String adoptType;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "项目来源")
    private String source;

}
