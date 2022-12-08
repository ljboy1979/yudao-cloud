package cn.acsm.module.transaction.order.dal.mysql.reservedetails;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.order.dal.dataobject.reservedetails.ReserveDetailsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.order.controller.admin.reservedetails.vo.*;

/**
 * 订单预定详情 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ReserveDetailsMapper extends BaseMapperX<ReserveDetailsDO> {

    default PageResult<ReserveDetailsDO> selectPage(ReserveDetailsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ReserveDetailsDO>()
                .likeIfPresent(ReserveDetailsDO::getCommodityName, reqVO.getCommodityName())
                .betweenIfPresent(ReserveDetailsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ReserveDetailsDO::getId));
    }

    default List<ReserveDetailsDO> selectList(ReserveDetailsExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ReserveDetailsDO>()
                .likeIfPresent(ReserveDetailsDO::getCommodityName, reqVO.getCommodityName())
                .betweenIfPresent(ReserveDetailsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ReserveDetailsDO::getId));
    }

}
