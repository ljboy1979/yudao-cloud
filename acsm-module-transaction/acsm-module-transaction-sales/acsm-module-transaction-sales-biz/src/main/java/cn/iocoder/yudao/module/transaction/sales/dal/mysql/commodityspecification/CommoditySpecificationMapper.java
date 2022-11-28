package cn.iocoder.yudao.module.transaction.sales.dal.mysql.commodityspecification;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.commodityspecification.vo.*;

/**
 * 商品规格 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface CommoditySpecificationMapper extends BaseMapperX<CommoditySpecificationDO> {

    default PageResult<CommoditySpecificationDO> selectPage(CommoditySpecificationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CommoditySpecificationDO>()
                .eqIfPresent(CommoditySpecificationDO::getCommodityId, reqVO.getCommodityId())
                .likeIfPresent(CommoditySpecificationDO::getSpecificationsName, reqVO.getSpecificationsName())
                .eqIfPresent(CommoditySpecificationDO::getPackagingType, reqVO.getPackagingType())
                .betweenIfPresent(CommoditySpecificationDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(CommoditySpecificationDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(CommoditySpecificationDO::getSource, reqVO.getSource())
                .orderByDesc(CommoditySpecificationDO::getId));
    }

    default List<CommoditySpecificationDO> selectList(CommoditySpecificationExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<CommoditySpecificationDO>()
                .eqIfPresent(CommoditySpecificationDO::getCommodityId, reqVO.getCommodityId())
                .likeIfPresent(CommoditySpecificationDO::getSpecificationsName, reqVO.getSpecificationsName())
                .eqIfPresent(CommoditySpecificationDO::getPackagingType, reqVO.getPackagingType())
                .betweenIfPresent(CommoditySpecificationDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(CommoditySpecificationDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(CommoditySpecificationDO::getSource, reqVO.getSource())
                .orderByDesc(CommoditySpecificationDO::getId));
    }

}
