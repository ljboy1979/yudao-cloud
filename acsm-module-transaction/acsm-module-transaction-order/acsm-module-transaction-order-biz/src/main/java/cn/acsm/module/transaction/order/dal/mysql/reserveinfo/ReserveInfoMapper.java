package cn.acsm.module.transaction.order.dal.mysql.reserveinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.order.dal.dataobject.reserveinfo.ReserveInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.order.controller.admin.reserveinfo.vo.*;

/**
 * 预定订单 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ReserveInfoMapper extends BaseMapperX<ReserveInfoDO> {

    default PageResult<ReserveInfoDO> selectPage(ReserveInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ReserveInfoDO>()
                .eqIfPresent(ReserveInfoDO::getPayType, reqVO.getPayType())
                .betweenIfPresent(ReserveInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ReserveInfoDO::getId));
    }

    default List<ReserveInfoDO> selectList(ReserveInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ReserveInfoDO>()
                .eqIfPresent(ReserveInfoDO::getPayType, reqVO.getPayType())
                .betweenIfPresent(ReserveInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ReserveInfoDO::getId));
    }

}
