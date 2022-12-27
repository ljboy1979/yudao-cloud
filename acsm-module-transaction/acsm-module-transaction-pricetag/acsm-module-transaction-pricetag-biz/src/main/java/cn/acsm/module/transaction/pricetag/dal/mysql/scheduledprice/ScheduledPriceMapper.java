package cn.acsm.module.transaction.pricetag.dal.mysql.scheduledprice;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.pricetag.dal.dataobject.scheduledprice.ScheduledPriceDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.pricetag.controller.admin.scheduledprice.vo.*;

/**
 * 预定价格 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ScheduledPriceMapper extends BaseMapperX<ScheduledPriceDO> {

    default PageResult<ScheduledPriceDO> selectPage(ScheduledPricePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ScheduledPriceDO>()
                .likeIfPresent(ScheduledPriceDO::getCommodityName, reqVO.getCommodityName())
                .betweenIfPresent(ScheduledPriceDO::getUpdateTime, reqVO.getUpdateTime())
                .orderByDesc(ScheduledPriceDO::getId));
    }

    default List<ScheduledPriceDO> selectList(ScheduledPriceExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ScheduledPriceDO>()
                .likeIfPresent(ScheduledPriceDO::getCommodityName, reqVO.getCommodityName())
                .betweenIfPresent(ScheduledPriceDO::getUpdateTime, reqVO.getUpdateTime())
                .orderByDesc(ScheduledPriceDO::getId));
    }

}
