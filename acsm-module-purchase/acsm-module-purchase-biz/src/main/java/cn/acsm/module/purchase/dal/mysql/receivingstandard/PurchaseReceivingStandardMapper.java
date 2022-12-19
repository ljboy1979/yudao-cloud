package cn.acsm.module.purchase.dal.mysql.receivingstandard;

import cn.acsm.module.purchase.controller.admin.receivingstandard.vo.PurchaseReceivingStandardExportReqVO;
import cn.acsm.module.purchase.controller.admin.receivingstandard.vo.PurchaseReceivingStandardPageReqVO;
import cn.acsm.module.purchase.dal.dataobject.receivingstandard.PurchaseReceivingStandardDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 收货标准 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PurchaseReceivingStandardMapper extends BaseMapperX<PurchaseReceivingStandardDO> {

    default PageResult<PurchaseReceivingStandardDO> selectPage(PurchaseReceivingStandardPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PurchaseReceivingStandardDO>()
                .likeIfPresent(PurchaseReceivingStandardDO::getName, reqVO.getName())
                .eqIfPresent(PurchaseReceivingStandardDO::getUpperLimit, reqVO.getUpperLimit())
                .eqIfPresent(PurchaseReceivingStandardDO::getLowerLimit, reqVO.getLowerLimit())
                .eqIfPresent(PurchaseReceivingStandardDO::getUnit, reqVO.getUnit())
                .betweenIfPresent(PurchaseReceivingStandardDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseReceivingStandardDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PurchaseReceivingStandardDO::getId));
    }

    default List<PurchaseReceivingStandardDO> selectList(PurchaseReceivingStandardExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PurchaseReceivingStandardDO>()
                .likeIfPresent(PurchaseReceivingStandardDO::getName, reqVO.getName())
                .eqIfPresent(PurchaseReceivingStandardDO::getUpperLimit, reqVO.getUpperLimit())
                .eqIfPresent(PurchaseReceivingStandardDO::getLowerLimit, reqVO.getLowerLimit())
                .eqIfPresent(PurchaseReceivingStandardDO::getUnit, reqVO.getUnit())
                .betweenIfPresent(PurchaseReceivingStandardDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(PurchaseReceivingStandardDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(PurchaseReceivingStandardDO::getId));
    }

}
