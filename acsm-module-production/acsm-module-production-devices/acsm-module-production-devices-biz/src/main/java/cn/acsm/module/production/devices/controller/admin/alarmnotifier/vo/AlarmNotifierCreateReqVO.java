package cn.acsm.module.production.devices.controller.admin.alarmnotifier.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 告警通知规则创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AlarmNotifierCreateReqVO extends AlarmNotifierBaseVO {

}
