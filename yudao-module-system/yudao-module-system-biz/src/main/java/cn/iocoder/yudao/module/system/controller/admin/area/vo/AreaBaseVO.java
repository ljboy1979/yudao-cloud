package cn.iocoder.yudao.module.system.controller.admin.area.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 行政区划 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AreaBaseVO {

    @ApiModelProperty(value = "区域编码", required = true)
    @NotNull(message = "区域编码不能为空")
    private String areaCode;

    @ApiModelProperty(value = "父级编号", required = true)
    @NotNull(message = "父级编号不能为空")
    private String parentCode;

    @ApiModelProperty(value = "所有父级编号", required = true)
    @NotNull(message = "所有父级编号不能为空")
    private String parentCodes;

    @ApiModelProperty(value = "本级排序号（升序）", required = true)
    private BigDecimal treeSort;

    @ApiModelProperty(value = "所有级别排序号", required = true)
    private String treeSorts;

    @ApiModelProperty(value = "是否最末级", required = true)
    private String treeLeaf;

    @ApiModelProperty(value = "层次级别", required = true)
    private BigDecimal treeLevel;

    @ApiModelProperty(value = "全节点名", required = true)
    @NotNull(message = "全节点名不能为空")
    private String treeNames;

    @ApiModelProperty(value = "区域名称", required = true)
    @NotNull(message = "区域名称不能为空")
    private String areaName;

    @ApiModelProperty(value = "区域类型")
    private String areaType;

    @ApiModelProperty(value = "状态(0正常 1停用)")
    private String status;

    @ApiModelProperty(value = "是否删除", required = true)
    private Boolean deleted;

    @ApiModelProperty(value = "创建者")
    private String creator;

    @ApiModelProperty(value = "创建时间", required = true)
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date createTime;

    @ApiModelProperty(value = "更新者")
    private String updater;

    @ApiModelProperty(value = "更新时间", required = true)
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date updateTime;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "地区拼音")
    private String areaEn;

    @ApiModelProperty(value = "上")
    private Double top;

    @ApiModelProperty(value = "下")
    private Double bottom;

    @ApiModelProperty(value = "左")
    private Double left;

    @ApiModelProperty(value = "右")
    private Double right;

    @ApiModelProperty(value = "经度")
    private Double longitude;

    @ApiModelProperty(value = "纬度")
    private Double latitude;

}
