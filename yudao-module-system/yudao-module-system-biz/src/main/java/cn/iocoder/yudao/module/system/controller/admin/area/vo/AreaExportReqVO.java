package cn.iocoder.yudao.module.system.controller.admin.area.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 行政区划 Excel 导出 Request VO", description = "参数和 AreaPageReqVO 是一致的")
@Data
public class AreaExportReqVO {

    @ApiModelProperty(value = "区域编码")
    private String areaCode;

    @ApiModelProperty(value = "父级编号")
    private String parentCode;

    @ApiModelProperty(value = "所有父级编号")
    private String parentCodes;

    @ApiModelProperty(value = "本级排序号（升序）")
    private BigDecimal treeSort;

    @ApiModelProperty(value = "所有级别排序号")
    private String treeSorts;

    @ApiModelProperty(value = "是否最末级")
    private String treeLeaf;

    @ApiModelProperty(value = "层次级别")
    private BigDecimal treeLevel;

    @ApiModelProperty(value = "全节点名")
    private String treeNames;

    @ApiModelProperty(value = "区域名称")
    private String areaName;

    @ApiModelProperty(value = "区域类型")
    private String areaType;

    @ApiModelProperty(value = "状态（0正常 1停用）")
    private String status;

    @ApiModelProperty(value = "是否删除")
    private Boolean deleted;

    @ApiModelProperty(value = "创建者")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "更新者")
    private String updater;

    @ApiModelProperty(value = "更新时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] updateTime;

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
