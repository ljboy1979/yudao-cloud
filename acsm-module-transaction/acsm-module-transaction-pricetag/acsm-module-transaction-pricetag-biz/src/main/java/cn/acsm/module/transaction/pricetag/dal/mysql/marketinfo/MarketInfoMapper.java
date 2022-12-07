package cn.acsm.module.transaction.pricetag.dal.mysql.marketinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketinfo.MarketInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.pricetag.controller.admin.marketinfo.vo.*;

/**
 * 市场信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface MarketInfoMapper extends BaseMapperX<MarketInfoDO> {

    default PageResult<MarketInfoDO> selectPage(MarketInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MarketInfoDO>()
                .likeIfPresent(MarketInfoDO::getMarketName, reqVO.getMarketName())
                .betweenIfPresent(MarketInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MarketInfoDO::getId));
    }

    default List<MarketInfoDO> selectList(MarketInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MarketInfoDO>()
                .likeIfPresent(MarketInfoDO::getMarketName, reqVO.getMarketName())
                .betweenIfPresent(MarketInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MarketInfoDO::getId));
    }

}
