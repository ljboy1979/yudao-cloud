package cn.acsm.module.service.controller.admin.serviceinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 服务 Excel VO
 *
 * @author smile
 */
@Data
public class ServiceInfoExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("服务编号")
    private String serviceCode;

    @ExcelProperty("服务名称")
    private String serviceName;

    @ExcelProperty("服务类型")
    private String serviceType;

    @ExcelProperty("服务提供者")
    private String serviceProvider;

    @ExcelProperty("服务详情")
    private String content;

    @ExcelProperty("服务缴费者")
    private String servicePayer;

    @ExcelProperty("开始时间")
    private Date startTime;

    @ExcelProperty("结束时间")
    private Date endTime;

    @ExcelProperty("服务状态(0上架中 1已下架)")
    private String state;

    @ExcelProperty("关联设施")
    private String induFacilityInfoId;

    @ExcelProperty("备注信息")
    private String remarks;

    @ExcelProperty("地块id")
    private String tunnelInfoId;

    @ExcelProperty("设备的id")
    private String devicesId;

    @ExcelProperty("经营主体的id")
    private String induSubjectInfoId;

    @ExcelProperty("载体的id(关联认养物/租凭物)")
    private String carrierId;

    @ExcelProperty("子表的表名")
    private String childrenTableName;

    @ExcelProperty("服务的费用")
    private String serviceFee;

    @ExcelProperty("所属分类id")
    private String categoryId;

    @ExcelProperty("可用时间段")
    private String availableTime;

    @ExcelProperty("农事类型")
    private String farmType;

    @ExcelProperty("服务简介")
    private String introduce;

    @ExcelProperty("服务地址")
    private String address;

    @ExcelProperty("服务轮播图")
    private String rotationImgs;

    @ExcelProperty("服务详情图")
    private String detailsImgs;

    @ExcelProperty("最大参与人数")
    private String maxAttendPeople;

    @ExcelProperty("实际参与人数")
    private String attendPeople;

    @ExcelProperty("基地id")
    private String basesId;

    @ExcelProperty("基地名称")
    private String basesName;

    @ExcelProperty("种植数量")
    private String plantNum;

    @ExcelProperty("种植品类")
    private String plantCropIds;

    @ExcelProperty("服务标签")
    private String label;

    @ExcelProperty("收藏数量")
    private String collectNum;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("项目来源")
    private String source;

}
