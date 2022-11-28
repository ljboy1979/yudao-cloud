package cn.iocoder.yudao.module.transaction.sales.dal.mysql.commoditycategory;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.commoditycategory.CommodityCategoryDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.commoditycategory.vo.*;

/**
 * 商品分类 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface CommodityCategoryMapper extends BaseMapperX<CommodityCategoryDO> {

    default PageResult<CommodityCategoryDO> selectPage(CommodityCategoryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CommodityCategoryDO>()
                .likeIfPresent(CommodityCategoryDO::getCommodityCategoryName, reqVO.getCommodityCategoryName())
                .eqIfPresent(CommodityCategoryDO::getParentCode, reqVO.getParentCode())
                .eqIfPresent(CommodityCategoryDO::getParentCodes, reqVO.getParentCodes())
                .eqIfPresent(CommodityCategoryDO::getTreeSort, reqVO.getTreeSort())
                .eqIfPresent(CommodityCategoryDO::getTreeSorts, reqVO.getTreeSorts())
                .eqIfPresent(CommodityCategoryDO::getTreeLeaf, reqVO.getTreeLeaf())
                .eqIfPresent(CommodityCategoryDO::getTreeLevel, reqVO.getTreeLevel())
                .eqIfPresent(CommodityCategoryDO::getTreeNames, reqVO.getTreeNames())
                .eqIfPresent(CommodityCategoryDO::getType, reqVO.getType())
                .eqIfPresent(CommodityCategoryDO::getState, reqVO.getState())
                .eqIfPresent(CommodityCategoryDO::getImgUrl, reqVO.getImgUrl())
                .eqIfPresent(CommodityCategoryDO::getOrder, reqVO.getOrder())
                .eqIfPresent(CommodityCategoryDO::getCommodityType, reqVO.getCommodityType())
                .eqIfPresent(CommodityCategoryDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(CommodityCategoryDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CommodityCategoryDO::getId));
    }

    default List<CommodityCategoryDO> selectList(CommodityCategoryExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<CommodityCategoryDO>()
                .likeIfPresent(CommodityCategoryDO::getCommodityCategoryName, reqVO.getCommodityCategoryName())
                .eqIfPresent(CommodityCategoryDO::getParentCode, reqVO.getParentCode())
                .eqIfPresent(CommodityCategoryDO::getParentCodes, reqVO.getParentCodes())
                .eqIfPresent(CommodityCategoryDO::getTreeSort, reqVO.getTreeSort())
                .eqIfPresent(CommodityCategoryDO::getTreeSorts, reqVO.getTreeSorts())
                .eqIfPresent(CommodityCategoryDO::getTreeLeaf, reqVO.getTreeLeaf())
                .eqIfPresent(CommodityCategoryDO::getTreeLevel, reqVO.getTreeLevel())
                .eqIfPresent(CommodityCategoryDO::getTreeNames, reqVO.getTreeNames())
                .eqIfPresent(CommodityCategoryDO::getType, reqVO.getType())
                .eqIfPresent(CommodityCategoryDO::getState, reqVO.getState())
                .eqIfPresent(CommodityCategoryDO::getImgUrl, reqVO.getImgUrl())
                .eqIfPresent(CommodityCategoryDO::getOrder, reqVO.getOrder())
                .eqIfPresent(CommodityCategoryDO::getCommodityType, reqVO.getCommodityType())
                .eqIfPresent(CommodityCategoryDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(CommodityCategoryDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CommodityCategoryDO::getId));
    }

}
