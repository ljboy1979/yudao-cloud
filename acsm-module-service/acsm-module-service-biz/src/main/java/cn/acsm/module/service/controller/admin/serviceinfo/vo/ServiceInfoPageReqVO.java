package cn.acsm.module.service.controller.admin.serviceinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 服务分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ServiceInfoPageReqVO extends PageParam {

    @ApiModelProperty(value = "服务编号")
    private String serviceCode;

    @ApiModelProperty(value = "服务名称")
    private String serviceName;

    @ApiModelProperty(value = "服务类型")
    private String serviceType;

    @ApiModelProperty(value = "服务提供者")
    private String serviceProvider;

    @ApiModelProperty(value = "服务详情")
    private String content;

    @ApiModelProperty(value = "服务缴费者")
    private String servicePayer;

    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] startTime;

    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] endTime;

    @ApiModelProperty(value = "服务状态(0上架中 1已下架)")
    private String state;

    @ApiModelProperty(value = "关联设施")
    private String induFacilityInfoId;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "地块id")
    private String tunnelInfoId;

    @ApiModelProperty(value = "设备的id")
    private String devicesId;

    @ApiModelProperty(value = "经营主体的id")
    private String induSubjectInfoId;

    @ApiModelProperty(value = "载体的id(关联认养物/租凭物)")
    private String carrierId;

    @ApiModelProperty(value = "子表的表名")
    private String childrenTableName;

    @ApiModelProperty(value = "服务的费用")
    private String serviceFee;

    @ApiModelProperty(value = "所属分类id")
    private String categoryId;

    @ApiModelProperty(value = "可用时间段")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private String[] availableTime;

    @ApiModelProperty(value = "农事类型")
    private String farmType;

    @ApiModelProperty(value = "服务简介")
    private String introduce;

    @ApiModelProperty(value = "服务地址")
    private String address;

    @ApiModelProperty(value = "服务轮播图")
    private String rotationImgs;

    @ApiModelProperty(value = "服务详情图")
    private String detailsImgs;

    @ApiModelProperty(value = "最大参与人数")
    private String maxAttendPeople;

    @ApiModelProperty(value = "实际参与人数")
    private String attendPeople;

    @ApiModelProperty(value = "基地id")
    private String basesId;

    @ApiModelProperty(value = "基地名称")
    private String basesName;

    @ApiModelProperty(value = "种植数量")
    private String plantNum;

    @ApiModelProperty(value = "种植品类")
    private String plantCropIds;

    @ApiModelProperty(value = "服务标签")
    private String label;

    @ApiModelProperty(value = "收藏数量")
    private String collectNum;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

    @ApiModelProperty(value = "项目来源")
    private String source;

    @ApiModelProperty(value = "服务ids")
    private String serviceIds;

}
