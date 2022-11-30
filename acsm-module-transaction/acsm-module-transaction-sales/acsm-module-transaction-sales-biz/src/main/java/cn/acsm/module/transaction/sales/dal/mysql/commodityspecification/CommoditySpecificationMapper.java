package cn.acsm.module.transaction.sales.dal.mysql.commodityspecification;

import java.util.*;

import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.CommoditySpecificationExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.CommoditySpecificationPageReqVO;
import cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

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
                .orderByDesc(CommoditySpecificationDO::getCreateTime));
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

    default Long findSelectCount(CommoditySpecificationDO commoditySpecificationDO) {
        return selectCount(new LambdaQueryWrapperX<CommoditySpecificationDO>()
                .eqIfPresent(CommoditySpecificationDO::getCommodityId, commoditySpecificationDO.getCommodityId())
                .eqIfPresent(CommoditySpecificationDO::getSpecificationsName, commoditySpecificationDO.getSpecificationsName())
                .eqIfPresent(CommoditySpecificationDO::getPackagingType, commoditySpecificationDO.getPackagingType())
                .eqIfPresent(CommoditySpecificationDO::getSubjectId, commoditySpecificationDO.getSubjectId())
                .eqIfPresent(CommoditySpecificationDO::getSource, commoditySpecificationDO.getSource())
                .notIn(CommoditySpecificationDO::getId, commoditySpecificationDO.getId())
                .orderByDesc(CommoditySpecificationDO::getId));
    }

}
