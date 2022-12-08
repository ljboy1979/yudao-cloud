package cn.acsm.module.transaction.order.dal.mysql.costinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.order.dal.dataobject.costinfo.CostInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.order.controller.admin.costinfo.vo.*;

/**
 * 费用 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface CostInfoMapper extends BaseMapperX<CostInfoDO> {

    default PageResult<CostInfoDO> selectPage(CostInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CostInfoDO>()
                .eqIfPresent(CostInfoDO::getCostNumber, reqVO.getCostNumber())
                .betweenIfPresent(CostInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CostInfoDO::getId));
    }

    default List<CostInfoDO> selectList(CostInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<CostInfoDO>()
                .eqIfPresent(CostInfoDO::getCostNumber, reqVO.getCostNumber())
                .betweenIfPresent(CostInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CostInfoDO::getId));
    }

}
