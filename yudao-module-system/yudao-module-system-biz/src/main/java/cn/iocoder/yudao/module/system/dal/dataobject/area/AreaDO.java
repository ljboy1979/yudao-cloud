package cn.iocoder.yudao.module.system.dal.dataobject.area;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * 行政区划 DO
 *
 * @author 芋道源码
 */
@TableName("system_area")
@KeySequence("system_area_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AreaDO extends BaseDO {
    /**
     * 行政区划id
     */
    @TableId(type = IdType.INPUT)
    private Long id;

    /**
     * 区域编码
     */
    private String areaCode;
    /**
     * 父级编号
     */
    private String parentCode;
    /**
     * 所有父级编号
     */
    private String parentCodes;
    /**
     * 本级排序号（升序）
     */
    private BigDecimal treeSort;
    /**
     * 所有级别排序号
     */
    private String treeSorts;
    /**
     * 是否最末级
     */
    private String treeLeaf;
    /**
     * 层次级别
     */
    private BigDecimal treeLevel;
    /**
     * 全节点名
     */
    private String treeNames;
    /**
     * 区域名称
     */
    private String areaName;
    /**
     * 区域类型
     */
    private String areaType;
    /**
     * 备注信息
     */
    private String remarks;
    /**
     * 地区拼音
     */
    private String areaEn;
    /**
     * 上
     */
    private Double top;
    /**
     * 下
     */
    private Double bottom;
    /**
     * 左
     */
    @TableField("`left`")
    private Double left;
    /**
     * 右
     */
    @TableField("`right`")
    private Double right;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 状态（0正常 1停用）
     */
    private String status;
}
