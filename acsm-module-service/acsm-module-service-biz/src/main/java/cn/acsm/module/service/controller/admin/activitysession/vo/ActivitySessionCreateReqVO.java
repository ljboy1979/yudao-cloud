package cn.acsm.module.service.controller.admin.activitysession.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 时间排期创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ActivitySessionCreateReqVO extends ActivitySessionBaseVO {

    @ApiModelProperty(value = "起止时间与人数List")
    private List<ActivitySessionBaseVO> roleIdss;

}
