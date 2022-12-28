package cn.acsm.module.transaction.pricetag.controller.admin.marketprice.vo;

import cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice.PriceTrendDO;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 市场价格 vo
 *
 * @author 芋道源码
 */
@Data
public class MarketPriceInfoVo{

    /**
     * id
     */
    @ApiModelProperty(value = "id", required = true)
    private String id;
    /**
     * 编码
     */
    @ApiModelProperty(value = "编码", required = true)
    private String code;
    /**
     * 市场商品名称
     */
    @ApiModelProperty(value = "市场商品名称", required = true)
    private String commodityName;
    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称", required = true)
    private String categoryName;
    /**
     * 规格名称
     */
    @ApiModelProperty(value = "规格名称", required = true)
    private String specificationsName;
    /**
     * 最高价
     */
    @ApiModelProperty(value = "最高价", required = true)
    private Float maxPrice;
    /**
     * 最低价
     */
    @ApiModelProperty(value = "最低价", required = true)
    private Float minPrice;
    /**
     * 平均价
     */
    @ApiModelProperty(value = "平均价", required = true)
    private Float middlePrice;
    /**
     * 计量单位名称
     */
    @ApiModelProperty(value = "计量单位名称", required = true)
    private String measurementUnitName;
    /**
     * 市场名称
     */
    @ApiModelProperty(value = "市场名称", required = true)
    private String marketName;

    @ApiModelProperty(value = "创建时间", required = true)
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date createTime;
    @ApiModelProperty(value = "更新时间", required = true)
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date updateTime;
    /**
     * 价格趋势
     */
    @ApiModelProperty(value = "价格趋势", required = true)
    private List<PriceTrendVO> priceTrendS;


}
