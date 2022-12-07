package cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 市场价格 DO
 *
 * @author 芋道源码
 */
@Data
public class MarketPriceInfoDO{

    /**
     * id
     */
    private String id;
    /**
     * 编码
     */
    private String code;
    /**
     * 市场商品id
     */
    private String commodityName;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 规格名称
     */
    private String specificationsName;
    /**
     * 最高价
     */
    private Float maxPrice;
    /**
     * 最低价
     */
    private Float minPrice;
    /**
     * 平均价
     */
    private Float middlePrice;
    /**
     * 计量单位名称
     */
    private String measurementUnitName;
    /**
     * 市场名称
     */
    private String marketName;
    /**
     * 最后更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;



}
