package cn.acsm.module.transaction.order.dal.mysql.settleinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.order.dal.dataobject.settleinfo.SettleInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.order.controller.admin.settleinfo.vo.*;

/**
 * 订单结账 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface SettleInfoMapper extends BaseMapperX<SettleInfoDO> {

    default PageResult<SettleInfoDO> selectPage(SettleInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SettleInfoDO>()
                .eqIfPresent(SettleInfoDO::getOrderId, reqVO.getOrderId())
                .betweenIfPresent(SettleInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SettleInfoDO::getId));
    }

    default List<SettleInfoDO> selectList(SettleInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<SettleInfoDO>()
                .eqIfPresent(SettleInfoDO::getOrderId, reqVO.getOrderId())
                .betweenIfPresent(SettleInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SettleInfoDO::getId));
    }

}
