package cn.acsm.module.transaction.order.dal.mysql.giftinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.order.dal.dataobject.giftinfo.GiftInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.order.controller.admin.giftinfo.vo.*;

/**
 * 赠品 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GiftInfoMapper extends BaseMapperX<GiftInfoDO> {

    default PageResult<GiftInfoDO> selectPage(GiftInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GiftInfoDO>()
                .eqIfPresent(GiftInfoDO::getSkuPackageOrderId, reqVO.getSkuPackageOrderId())
                .betweenIfPresent(GiftInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(GiftInfoDO::getId));
    }

    default List<GiftInfoDO> selectList(GiftInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<GiftInfoDO>()
                .eqIfPresent(GiftInfoDO::getSkuPackageOrderId, reqVO.getSkuPackageOrderId())
                .betweenIfPresent(GiftInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(GiftInfoDO::getId));
    }

}
