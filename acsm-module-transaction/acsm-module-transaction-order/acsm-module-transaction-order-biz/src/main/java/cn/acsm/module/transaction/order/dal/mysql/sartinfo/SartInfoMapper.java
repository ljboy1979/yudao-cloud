package cn.acsm.module.transaction.order.dal.mysql.sartinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.order.dal.dataobject.sartinfo.SartInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.order.controller.admin.sartinfo.vo.*;

/**
 * 购物车 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface SartInfoMapper extends BaseMapperX<SartInfoDO> {

    default PageResult<SartInfoDO> selectPage(SartInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SartInfoDO>()
                .eqIfPresent(SartInfoDO::getShelvesId, reqVO.getShelvesId())
                .likeIfPresent(SartInfoDO::getShelvesName, reqVO.getShelvesName())
                .eqIfPresent(SartInfoDO::getPayStatus, reqVO.getPayStatus())
                .betweenIfPresent(SartInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SartInfoDO::getId));
    }

    default List<SartInfoDO> selectList(SartInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<SartInfoDO>()
                .eqIfPresent(SartInfoDO::getShelvesId, reqVO.getShelvesId())
                .likeIfPresent(SartInfoDO::getShelvesName, reqVO.getShelvesName())
                .eqIfPresent(SartInfoDO::getPayStatus, reqVO.getPayStatus())
                .betweenIfPresent(SartInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SartInfoDO::getId));
    }

}
