package cn.acsm.module.transaction.pricetag.dal.dataobject.marketinfo;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 市场信息 DO
 *
 * @author 芋道源码
 */
@TableName("pricetag_market_info")
@KeySequence("pricetag_market_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketInfoDO extends BaseDO {

    /**
     * 编号
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 市场编号
     */
    private String marketCode;
    /**
     * 市场名称
     */
    private String marketName;
    /**
     * 市场地址
     */
    private String marketAddress;
    /**
     * 省
     */
    private String provCn;
    /**
     * 市
     */
    private String cityCn;
    /**
     * 区县
     */
    private String countyCn;

    /**
     * 省ID
     */
    private String provCode;

    /**
     * 市ID
     */
    private String cityCode;

    /**
     * 区县ID
     */
    private String countyCode;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 来源
     */
    private String source;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 经营主体id
     */
    private String subjectId;

}
