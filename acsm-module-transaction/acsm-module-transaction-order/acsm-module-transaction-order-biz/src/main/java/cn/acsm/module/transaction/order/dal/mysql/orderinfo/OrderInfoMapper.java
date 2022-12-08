package cn.acsm.module.transaction.order.dal.mysql.orderinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.order.dal.dataobject.orderinfo.OrderInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.order.controller.admin.orderinfo.vo.*;

/**
 * 订单 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface OrderInfoMapper extends BaseMapperX<OrderInfoDO> {

    default PageResult<OrderInfoDO> selectPage(OrderInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<OrderInfoDO>()
                .betweenIfPresent(OrderInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(OrderInfoDO::getId));
    }

    default List<OrderInfoDO> selectList(OrderInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<OrderInfoDO>()
                .betweenIfPresent(OrderInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(OrderInfoDO::getId));
    }

}
