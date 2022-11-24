package cn.acsm.module.enterprise.controller.admin.policysubsidiesinfo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

@ApiModel("管理后台 - 企业政策补贴信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PolicySubsidiesInfoRespVO extends PolicySubsidiesInfoBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    private Long id;

    @ApiModelProperty(value = "创建者")
    private String creator;

    @ApiModelProperty(value = "创建时间", required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "更新者")
    private String updater;

    @ApiModelProperty(value = "更新时间", required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
