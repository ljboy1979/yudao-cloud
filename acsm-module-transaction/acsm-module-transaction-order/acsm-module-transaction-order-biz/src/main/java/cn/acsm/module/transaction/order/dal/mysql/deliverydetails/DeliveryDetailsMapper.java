package cn.acsm.module.transaction.order.dal.mysql.deliverydetails;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.order.dal.dataobject.deliverydetails.DeliveryDetailsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.order.controller.admin.deliverydetails.vo.*;

/**
 * 配送详情 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DeliveryDetailsMapper extends BaseMapperX<DeliveryDetailsDO> {

    default PageResult<DeliveryDetailsDO> selectPage(DeliveryDetailsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DeliveryDetailsDO>()
                .eqIfPresent(DeliveryDetailsDO::getDeliveryId, reqVO.getDeliveryId())
                .likeIfPresent(DeliveryDetailsDO::getName, reqVO.getName())
                .orderByDesc(DeliveryDetailsDO::getId));
    }

    default List<DeliveryDetailsDO> selectList(DeliveryDetailsExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<DeliveryDetailsDO>()
                .eqIfPresent(DeliveryDetailsDO::getDeliveryId, reqVO.getDeliveryId())
                .likeIfPresent(DeliveryDetailsDO::getName, reqVO.getName())
                .orderByDesc(DeliveryDetailsDO::getId));
    }

}
