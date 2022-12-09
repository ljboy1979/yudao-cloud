package cn.acsm.module.resource.dal.dataobject.adoptcontent;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 认养物/租凭物 DO
 *
 * @author smile
 */
@TableName("resource_adopt_content")
@KeySequence("resource_adopt_content_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdoptContentDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 关联服务
     */
    private String serviceInfoId;
    /**
     * 编号
     */
    private String adoptContentCode;
    /**
     * 名称
     */
    private String name;
    /**
     * 类型
     */
    private String type;
    /**
     * 省市区
     */
    private String country;
    /**
     * 详细地址
     */
    private String addRess;
    /**
     * 经度
     */
    private BigDecimal longitude;
    /**
     * 维度
     */
    private BigDecimal latitude;
    /**
     * 认养状态
     */
    private String adoptState;
    /**
     * 认养方式
     */
    private String adoptWay;
    /**
     * 关联设备
     */
    private String deviceId;
    /**
     * 关联地块
     */
    private String tunnelInfoId;
    /**
     * 设施id
     */
    private String induFacilityInfoId;
    /**
     * 1 是植株/个体 空是认养
     */
    private String plantType;
    /**
     * 种植时间
     */
    private Date plantTime;
    /**
     * 种植的行号
     */
    private String plantX;
    /**
     * 种植的列号
     */
    private String plantY;
    /**
     * 介绍
     */
    private String introduce;
    /**
     * 年龄
     */
    private String age;
    /**
     * 习性
     */
    private String habit;
    /**
     * 体重
     */
    private String weight;
    /**
     * 身高
     */
    private String height;
    /**
     * 性别
     */
    private String gender;
    /**
     * 血统
     */
    private String ancestry;
    /**
     * 特长
     */
    private String strongPoint;
    /**
     * 品种
     */
    private String plantCropId;
    /**
     * 植株/个体的id
     */
    private String tunnelPlanterId;
    /**
     * 关联代理商
     */
    private String agents;
    /**
     * 分类id
     */
    private String categoryId;
    /**
     * 认养名额总数
     */
    private Integer adoptSum;
    /**
     * 认养数
     */
    private Integer adoptNumber;
    /**
     * 区域id
     */
    private String partitionsId;
    /**
     * 资源类型字段（1-认养物；2-租赁物）
     */
    private String resourceType;
    /**
     * 群体id
     */
    private String groupId;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 项目来源
     */
    private String source;

}
