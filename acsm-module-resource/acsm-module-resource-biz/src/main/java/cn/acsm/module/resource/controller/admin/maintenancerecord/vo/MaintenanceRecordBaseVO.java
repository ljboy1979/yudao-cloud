package cn.acsm.module.resource.controller.admin.maintenancerecord.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 服务资源-养护记录 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class MaintenanceRecordBaseVO {

    @ApiModelProperty(value = "关联认养物/租凭物")
    private String serviceAdoptContentId;

    @ApiModelProperty(value = "养护人")
    private String maintenanceName;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "开始时间")
    private Date beginTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "项目来源")
    private String source;

    @ApiModelProperty(value = "经营主体id")
    private String subjectId;

}
