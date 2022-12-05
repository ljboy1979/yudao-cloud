package cn.acsm.module.enterprise.controller.admin.othercertificateinfo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
* 经营主体其他证件 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class OtherCertificateInfoBaseVO {

    @ApiModelProperty(value = "经营主体ID")
    private Long enterpriseId;

    @ApiModelProperty(value = "证件类型")
    private Integer certificateType;

    @ApiModelProperty(value = "证件名称")
    private String certificateName;

    @ApiModelProperty(value = "证件号")
    private String certificateNo;

    @ApiModelProperty(value = "证件照片")
    private String certificatePhoto;

    @ApiModelProperty(value = "证件截止日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date certificateEndTime;

    @ApiModelProperty(value = "租户集合")
    private Long source;

    @ApiModelProperty(value = "经营主体ID")
    private Long subjectId;

}
