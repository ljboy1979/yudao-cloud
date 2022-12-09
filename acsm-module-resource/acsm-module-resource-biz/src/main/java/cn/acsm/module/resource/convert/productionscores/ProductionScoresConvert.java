package cn.acsm.module.resource.convert.productionscores;

import cn.acsm.module.resource.controller.admin.productionscores.vo.ProductionScoresCreateReqVO;
import cn.acsm.module.resource.controller.admin.productionscores.vo.ProductionScoresExcelVO;
import cn.acsm.module.resource.controller.admin.productionscores.vo.ProductionScoresRespVO;
import cn.acsm.module.resource.controller.admin.productionscores.vo.ProductionScoresUpdateReqVO;
import cn.acsm.module.resource.dal.dataobject.productionscores.ProductionScoresDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 服务资源-生产品种 Convert
 *
 * @author smile
 */
@Mapper
public interface ProductionScoresConvert {

    ProductionScoresConvert INSTANCE = Mappers.getMapper(ProductionScoresConvert.class);

    ProductionScoresDO convert(ProductionScoresCreateReqVO bean);

    ProductionScoresDO convert(ProductionScoresUpdateReqVO bean);

    ProductionScoresRespVO convert(ProductionScoresDO bean);

    List<ProductionScoresRespVO> convertList(List<ProductionScoresDO> list);

    PageResult<ProductionScoresRespVO> convertPage(PageResult<ProductionScoresDO> page);

    List<ProductionScoresExcelVO> convertList02(List<ProductionScoresDO> list);

}
