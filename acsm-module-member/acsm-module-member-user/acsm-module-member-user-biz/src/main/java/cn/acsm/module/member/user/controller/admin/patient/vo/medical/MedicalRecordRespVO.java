package cn.acsm.module.member.user.controller.admin.patient.vo.medical;

import lombok.*;

import java.time.LocalDateTime;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 医嘱记录 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MedicalRecordRespVO extends MedicalRecordBaseVO {

    @ApiModelProperty(value = "主键ID", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private LocalDateTime createTime;

}
