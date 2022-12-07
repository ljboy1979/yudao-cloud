package cn.acsm.module.transaction.sales.dal.mysql.salespackage;

import java.util.*;

import cn.acsm.module.transaction.sales.api.dto.ShelvesSalesReqDto;
import cn.acsm.module.transaction.sales.dal.dataobject.shelves.ShelvesSalesRespDo;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.sales.dal.dataobject.salespackage.PackageDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.sales.controller.admin.salespackage.vo.*;

/**
 * 套餐 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PackageMapper extends BaseMapperX<PackageDO> {

    default PageResult<PackageDO> selectPage(PackagePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PackageDO>()
                .likeIfPresent(PackageDO::getName, reqVO.getName())
                .eqIfPresent(PackageDO::getSort, reqVO.getSort())
                .eqIfPresent(PackageDO::getMiniClassificationIdOne, reqVO.getMiniClassificationIdOne())
                .eqIfPresent(PackageDO::getMiniClassificationIdTwo, reqVO.getMiniClassificationIdTwo())
                .likeIfPresent(PackageDO::getCommodityName, reqVO.getCommodityName())
                .eqIfPresent(PackageDO::getVideo, reqVO.getVideo())
                .eqIfPresent(PackageDO::getProcessTag, reqVO.getProcessTag())
                .eqIfPresent(PackageDO::getLogisticsFees, reqVO.getLogisticsFees())
                .eqIfPresent(PackageDO::getOsCommodityFishingId, reqVO.getOsCommodityFishingId())
                .eqIfPresent(PackageDO::getProductSpecificationsFishingId, reqVO.getProductSpecificationsFishingId())
                .eqIfPresent(PackageDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(PackageDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PackageDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PackageDO::getId));
    }

    default List<PackageDO> selectList(PackageExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PackageDO>()
                .likeIfPresent(PackageDO::getName, reqVO.getName())
                .eqIfPresent(PackageDO::getSort, reqVO.getSort())
                .eqIfPresent(PackageDO::getMiniClassificationIdOne, reqVO.getMiniClassificationIdOne())
                .eqIfPresent(PackageDO::getMiniClassificationIdTwo, reqVO.getMiniClassificationIdTwo())
                .likeIfPresent(PackageDO::getCommodityName, reqVO.getCommodityName())
                .eqIfPresent(PackageDO::getVideo, reqVO.getVideo())
                .eqIfPresent(PackageDO::getProcessTag, reqVO.getProcessTag())
                .eqIfPresent(PackageDO::getLogisticsFees, reqVO.getLogisticsFees())
                .eqIfPresent(PackageDO::getOsCommodityFishingId, reqVO.getOsCommodityFishingId())
                .eqIfPresent(PackageDO::getProductSpecificationsFishingId, reqVO.getProductSpecificationsFishingId())
                .eqIfPresent(PackageDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(PackageDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PackageDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PackageDO::getId));
    }

    default Long findSelectCount(PackageDO packageDO) {
        return selectCount(new LambdaQueryWrapperX<PackageDO>()
                .eqIfPresent(PackageDO::getName, packageDO.getName())
                .eqIfPresent(PackageDO::getSort, packageDO.getSort())
                .eqIfPresent(PackageDO::getMiniClassificationIdOne, packageDO.getMiniClassificationIdOne())
                .eqIfPresent(PackageDO::getMiniClassificationIdTwo, packageDO.getMiniClassificationIdTwo())
                .likeIfPresent(PackageDO::getCommodityName, packageDO.getCommodityName())
                .eqIfPresent(PackageDO::getVideo, packageDO.getVideo())
                .eqIfPresent(PackageDO::getProcessTag, packageDO.getProcessTag())
                .eqIfPresent(PackageDO::getLogisticsFees, packageDO.getLogisticsFees())
                .eqIfPresent(PackageDO::getOsCommodityFishingId, packageDO.getOsCommodityFishingId())
                .eqIfPresent(PackageDO::getProductSpecificationsFishingId, packageDO.getProductSpecificationsFishingId())
                .eqIfPresent(PackageDO::getStatus, packageDO.getStatus())
                .eqIfPresent(PackageDO::getSubjectId, packageDO.getSubjectId())
                .notIn(PackageDO::getId,packageDO.getId())
                .orderByDesc(PackageDO::getId));
    }

    List<ShelvesSalesRespDo> findSales(ShelvesSalesReqDto shelvesSalesReqDto);

    List<ShelvesSalesRespDo> findSpecifications(ShelvesSalesReqDto shelvesSalesReqDto);
}
