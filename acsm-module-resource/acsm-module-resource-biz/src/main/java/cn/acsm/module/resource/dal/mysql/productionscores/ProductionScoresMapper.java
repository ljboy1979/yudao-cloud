package cn.acsm.module.resource.dal.mysql.productionscores;

import java.util.*;

import cn.acsm.module.resource.controller.admin.productionscores.vo.ProductionScoresExportReqVO;
import cn.acsm.module.resource.controller.admin.productionscores.vo.ProductionScoresPageReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.resource.dal.dataobject.productionscores.ProductionScoresDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 服务资源-生产品种 Mapper
 *
 * @author smile
 */
@Mapper
public interface ProductionScoresMapper extends BaseMapperX<ProductionScoresDO> {

    default PageResult<ProductionScoresDO> selectPage(ProductionScoresPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProductionScoresDO>()
                .eqIfPresent(ProductionScoresDO::getServiceAdoptContentId, reqVO.getServiceAdoptContentId())
                .eqIfPresent(ProductionScoresDO::getProductionScoresId, reqVO.getProductionScoresId())
                .eqIfPresent(ProductionScoresDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ProductionScoresDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ProductionScoresDO::getSource, reqVO.getSource())
                .eqIfPresent(ProductionScoresDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ProductionScoresDO::getId));
    }

    default List<ProductionScoresDO> selectList(ProductionScoresExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ProductionScoresDO>()
                .eqIfPresent(ProductionScoresDO::getServiceAdoptContentId, reqVO.getServiceAdoptContentId())
                .eqIfPresent(ProductionScoresDO::getProductionScoresId, reqVO.getProductionScoresId())
                .eqIfPresent(ProductionScoresDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ProductionScoresDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ProductionScoresDO::getSource, reqVO.getSource())
                .eqIfPresent(ProductionScoresDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ProductionScoresDO::getId));
    }

}
