package cn.acsm.module.transaction.order.dal.mysql.orderdetail;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.order.dal.dataobject.orderdetail.OrderDetailDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.order.controller.admin.orderdetail.vo.*;

/**
 * 订单详情 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface OrderDetailMapper extends BaseMapperX<OrderDetailDO> {

    default PageResult<OrderDetailDO> selectPage(OrderDetailPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<OrderDetailDO>()
                .likeIfPresent(OrderDetailDO::getShelvesName, reqVO.getShelvesName())
                .likeIfPresent(OrderDetailDO::getSpecificationName, reqVO.getSpecificationName())
                .betweenIfPresent(OrderDetailDO::getDeliveryTime, reqVO.getDeliveryTime())
                .orderByDesc(OrderDetailDO::getId));
    }

    default List<OrderDetailDO> selectList(OrderDetailExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<OrderDetailDO>()
                .likeIfPresent(OrderDetailDO::getShelvesName, reqVO.getShelvesName())
                .likeIfPresent(OrderDetailDO::getSpecificationName, reqVO.getSpecificationName())
                .betweenIfPresent(OrderDetailDO::getDeliveryTime, reqVO.getDeliveryTime())
                .orderByDesc(OrderDetailDO::getId));
    }

}
