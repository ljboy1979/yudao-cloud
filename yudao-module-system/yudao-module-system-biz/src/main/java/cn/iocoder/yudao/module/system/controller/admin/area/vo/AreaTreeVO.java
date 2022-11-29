package cn.iocoder.yudao.module.system.controller.admin.area.vo;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.area.AreaTreeEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description
 * @Author wangd
 * @Date Created in 2022/11/28
 */
@ApiModel("管理后台 - 行政区划 Tree VO")
@Data
public class AreaTreeVO extends AreaTreeEntity {
    @ApiModelProperty(value = "区域编码", required = true)
    private String areaCode;

    @ApiModelProperty(value = "父级编号", required = true)
    private String parentCode;

    @ApiModelProperty(value = "所有父级编号", required = true)
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
    private String treeNames;

    @ApiModelProperty(value = "区域名称", required = true)
    private String areaName;

    @ApiModelProperty(value = "区域类型")
    private String areaType;

    @ApiModelProperty(value = "是否删除", required = true)
    private Boolean deleted;

    @ApiModelProperty(value = "创建者")
    private String creator;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    @ApiModelProperty(value = "更新者")
    private String updater;

    @ApiModelProperty(value = "更新时间", required = true)
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
