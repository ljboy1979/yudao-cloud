package cn.acsm.module.transaction.pricetag.dal.mysql.marketclassify;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketclassify.MarketClassifyDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.pricetag.controller.admin.marketclassify.vo.*;

/**
 * 市场分类 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface MarketClassifyMapper extends BaseMapperX<MarketClassifyDO> {

    default PageResult<MarketClassifyDO> selectPage(MarketClassifyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MarketClassifyDO>()
                .likeIfPresent(MarketClassifyDO::getCategoryName, reqVO.getCategoryName())
                .betweenIfPresent(MarketClassifyDO::getUpdateTime, reqVO.getUpdateTime())
                .orderByDesc(MarketClassifyDO::getId));
    }

    default List<MarketClassifyDO> selectList(MarketClassifyExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MarketClassifyDO>()
                .likeIfPresent(MarketClassifyDO::getCategoryName, reqVO.getCategoryName())
                .betweenIfPresent(MarketClassifyDO::getUpdateTime, reqVO.getUpdateTime())
                .orderByDesc(MarketClassifyDO::getId));
    }

    default List<MarketClassifyDO> selectListToTree(MarketClassifyTreeVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MarketClassifyDO>()
                .likeIfPresent(MarketClassifyDO::getCategoryName, reqVO.getCategoryName())
                .orderByDesc(MarketClassifyDO::getId));
    }

}
