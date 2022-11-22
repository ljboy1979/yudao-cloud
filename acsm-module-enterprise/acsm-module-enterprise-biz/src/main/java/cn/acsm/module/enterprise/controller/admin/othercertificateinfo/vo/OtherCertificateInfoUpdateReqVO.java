package cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 经营主体其他证件更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OtherCertificateInfoUpdateReqVO extends OtherCertificateInfoBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    @NotNull(message = "编号不能为空")
    private Long id;

    @ApiModelProperty(value = "证件照片")
    private String certificatePhoto;

    @ApiModelProperty(value = "租户编号", required = true)
    @NotNull(message = "租户编号不能为空")
    private Long tenantId;

}
