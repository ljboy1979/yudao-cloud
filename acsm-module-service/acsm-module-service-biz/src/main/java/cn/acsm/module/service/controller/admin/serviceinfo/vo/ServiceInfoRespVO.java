package cn.acsm.module.service.controller.admin.serviceinfo.vo;

import cn.iocoder.yudao.module.system.api.dict.dto.DictDataRespDTO;
import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 服务 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ServiceInfoRespVO extends ServiceInfoBaseVO {

    @ApiModelProperty(value = "编号", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    @ApiModelProperty(value = "字典数据")
    private DictDataRespDTO dictDataRespDTO;

    @ApiModelProperty(value = "关联认养/租赁名称")
    private String carrierNames;

}
