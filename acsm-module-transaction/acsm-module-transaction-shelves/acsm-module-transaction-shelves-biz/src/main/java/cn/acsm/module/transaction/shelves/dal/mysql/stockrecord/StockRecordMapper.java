package cn.acsm.module.transaction.shelves.dal.mysql.stockrecord;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.shelves.dal.dataobject.stockrecord.StockRecordDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.shelves.controller.admin.stockrecord.vo.*;

/**
 * 货架库存记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface StockRecordMapper extends BaseMapperX<StockRecordDO> {

    default PageResult<StockRecordDO> selectPage(StockRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<StockRecordDO>()
                .eqIfPresent(StockRecordDO::getSpecificationsId, reqVO.getSpecificationsId())
                .eqIfPresent(StockRecordDO::getType, reqVO.getType())
                .eqIfPresent(StockRecordDO::getAmount, reqVO.getAmount())
                .eqIfPresent(StockRecordDO::getRemark, reqVO.getRemark())
                .eqIfPresent(StockRecordDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(StockRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(StockRecordDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(StockRecordDO::getSource, reqVO.getSource())
                .orderByDesc(StockRecordDO::getId));
    }

    default List<StockRecordDO> selectList(StockRecordExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<StockRecordDO>()
                .eqIfPresent(StockRecordDO::getSpecificationsId, reqVO.getSpecificationsId())
                .eqIfPresent(StockRecordDO::getType, reqVO.getType())
                .eqIfPresent(StockRecordDO::getAmount, reqVO.getAmount())
                .eqIfPresent(StockRecordDO::getRemark, reqVO.getRemark())
                .eqIfPresent(StockRecordDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(StockRecordDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(StockRecordDO::getSubjectId, reqVO.getSubjectId())
                .eqIfPresent(StockRecordDO::getSource, reqVO.getSource())
                .orderByDesc(StockRecordDO::getId));
    }

}
