package cn.acsm.module.transaction.sales.dal.mysql.commodityspecification;

import java.util.*;

import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.CommoditySpecificationExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.CommoditySpecificationPageReqVO;
import cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.sales.controller.admin.commodityspecification.vo.*;

/**
 * 商品规格 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface CommoditySpecificationMapper extends BaseMapperX<cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO> {

    default PageResult<cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO> selectPage(CommoditySpecificationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO>()
                .eqIfPresent(cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO::getCommodityId, reqVO.getCommodityId())
                .likeIfPresent(cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO::getSpecificationsName, reqVO.getSpecificationsName())
                .eqIfPresent(cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO::getPackagingType, reqVO.getPackagingType())
                .betweenIfPresent(cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO::getSource, reqVO.getSource())
                .orderByDesc(cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO::getId));
    }

    default List<cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO> selectList(CommoditySpecificationExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO>()
                .eqIfPresent(cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO::getCommodityId, reqVO.getCommodityId())
                .likeIfPresent(cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO::getSpecificationsName, reqVO.getSpecificationsName())
                .eqIfPresent(cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO::getPackagingType, reqVO.getPackagingType())
                .betweenIfPresent(cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(cn.acsm.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO::getSource, reqVO.getSource())
                .orderByDesc(CommoditySpecificationDO::getId));
    }

}
