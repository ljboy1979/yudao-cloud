package cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 经营主体其他证件创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OtherCertificateInfoCreateReqVO extends OtherCertificateInfoBaseVO {

    @ApiModelProperty(value = "证件照片")
    private String certificatePhoto;

}
