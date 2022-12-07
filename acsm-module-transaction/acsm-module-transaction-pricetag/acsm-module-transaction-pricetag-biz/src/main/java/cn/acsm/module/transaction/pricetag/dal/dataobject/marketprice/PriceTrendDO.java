package cn.acsm.module.transaction.pricetag.dal.dataobject.marketprice;

import lombok.Data;

@Data
public class PriceTrendDO {
    /**
     * 日期
     */
    private String time;

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
}
