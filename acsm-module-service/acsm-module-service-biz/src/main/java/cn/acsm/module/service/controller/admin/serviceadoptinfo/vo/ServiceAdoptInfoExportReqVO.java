package cn.acsm.module.service.controller.admin.serviceadoptinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 认养信息 Excel 导出 Request VO", description = "参数和 ServiceAdoptInfoPageReqVO 是一致的")
@Data
public class ServiceAdoptInfoExportReqVO {

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

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "项目来源")
    private String source;

}
