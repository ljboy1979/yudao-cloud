package cn.acsm.module.transaction.order.dal.mysql.deliveryinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.order.dal.dataobject.deliveryinfo.DeliveryInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.order.controller.admin.deliveryinfo.vo.*;

/**
 * 配送 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DeliveryInfoMapper extends BaseMapperX<DeliveryInfoDO> {

    default PageResult<DeliveryInfoDO> selectPage(DeliveryInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DeliveryInfoDO>()
                .betweenIfPresent(DeliveryInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(DeliveryInfoDO::getId));
    }

    default List<DeliveryInfoDO> selectList(DeliveryInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<DeliveryInfoDO>()
                .betweenIfPresent(DeliveryInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(DeliveryInfoDO::getId));
    }

}
