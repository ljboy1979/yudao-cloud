package cn.acsm.module.transaction.shelves.dal.mysql.stockclassify;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.transaction.shelves.dal.dataobject.stockclassify.StockClassifyDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.transaction.shelves.controller.admin.stockclassify.vo.*;

/**
 * 库存分类 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface StockClassifyMapper extends BaseMapperX<StockClassifyDO> {

    default PageResult<StockClassifyDO> selectPage(StockClassifyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<StockClassifyDO>()
                .likeIfPresent(StockClassifyDO::getClassifyName, reqVO.getClassifyName())
                .betweenIfPresent(StockClassifyDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(StockClassifyDO::getId));
    }

    default List<StockClassifyDO> selectList(StockClassifyExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<StockClassifyDO>()
                .likeIfPresent(StockClassifyDO::getClassifyName, reqVO.getClassifyName())
                .betweenIfPresent(StockClassifyDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(StockClassifyDO::getId));
    }

    default List<StockClassifyDO> selectListToTree(StockClassifyTreeVO reqVO) {
        return selectList(new LambdaQueryWrapperX<StockClassifyDO>()
                //.likeIfPresent(StockClassifyDO::getClassifyName, reqVO.getClassifyName())
                .orderByDesc(StockClassifyDO::getId));
    }

    default List<StockClassifyDO> findClassifyList(StockClassifyTreeVO reqVO) {
        return selectList(new LambdaQueryWrapperX<StockClassifyDO>()
                .likeIfPresent(StockClassifyDO::getClassifyName, reqVO.getClassifyName())
                .eqIfPresent(StockClassifyDO::getTreeLevel,reqVO.getTreeLevel())
                .orderByDesc(StockClassifyDO::getId));
    }

}
