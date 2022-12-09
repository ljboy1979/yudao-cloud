package cn.acsm.module.service.dal.dataobject.serviceinfo;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 服务 DO
 *
 * @author smile
 */
@TableName("service_service_info")
@KeySequence("service_service_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceInfoDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 服务编号
     */
    private String serviceCode;
    /**
     * 服务名称
     */
    private String serviceName;
    /**
     * 服务类型
     */
    private String serviceType;
    /**
     * 服务提供者
     */
    private String serviceProvider;
    /**
     * 服务详情
     */
    private String content;
    /**
     * 服务缴费者
     */
    private String servicePayer;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 服务状态(0上架中 1已下架)
     */
    private String state;
    /**
     * 关联设施
     */
    private String induFacilityInfoId;
    /**
     * 备注信息
     */
    private String remarks;
    /**
     * 地块id
     */
    private String tunnelInfoId;
    /**
     * 设备的id
     */
    private String devicesId;
    /**
     * 经营主体的id
     */
    private String induSubjectInfoId;
    /**
     * 载体的id(关联认养物/租凭物)
     */
    private String carrierId;
    /**
     * 子表的表名
     */
    private String childrenTableName;
    /**
     * 服务的费用
     */
    private String serviceFee;
    /**
     * 所属分类id
     */
    private String categoryId;
    /**
     * 可用时间段
     */
    private String availableTime;
    /**
     * 农事类型
     */
    private String farmType;
    /**
     * 服务简介
     */
    private String introduce;
    /**
     * 服务地址
     */
    private String address;
    /**
     * 服务轮播图
     */
    private String rotationImgs;
    /**
     * 服务详情图
     */
    private String detailsImgs;
    /**
     * 最大参与人数
     */
    private String maxAttendPeople;
    /**
     * 实际参与人数
     */
    private String attendPeople;
    /**
     * 基地id
     */
    private String basesId;
    /**
     * 基地名称
     */
    private String basesName;
    /**
     * 种植数量
     */
    private String plantNum;
    /**
     * 种植品类
     */
    private String plantCropIds;
    /**
     * 服务标签
     */
    private String label;
    /**
     * 收藏数量
     */
    private String collectNum;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 项目来源
     */
    private String source;

}
