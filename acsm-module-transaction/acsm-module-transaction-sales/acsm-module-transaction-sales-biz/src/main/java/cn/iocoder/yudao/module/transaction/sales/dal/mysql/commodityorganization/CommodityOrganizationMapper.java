package cn.iocoder.yudao.module.transaction.sales.dal.mysql.commodityorganization;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.commodityorganization.CommodityOrganizationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.commodityorganization.vo.*;

/**
 * 商品组成 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface CommodityOrganizationMapper extends BaseMapperX<CommodityOrganizationDO> {

    default PageResult<CommodityOrganizationDO> selectPage(CommodityOrganizationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CommodityOrganizationDO>()
                .eqIfPresent(CommodityOrganizationDO::getOrganizationNumber, reqVO.getOrganizationNumber())
                .likeIfPresent(CommodityOrganizationDO::getOrganizationName, reqVO.getOrganizationName())
                .betweenIfPresent(CommodityOrganizationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CommodityOrganizationDO::getId));
    }

    default List<CommodityOrganizationDO> selectList(CommodityOrganizationExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<CommodityOrganizationDO>()
                .eqIfPresent(CommodityOrganizationDO::getOrganizationNumber, reqVO.getOrganizationNumber())
                .likeIfPresent(CommodityOrganizationDO::getOrganizationName, reqVO.getOrganizationName())
                .betweenIfPresent(CommodityOrganizationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CommodityOrganizationDO::getId));
    }

}
