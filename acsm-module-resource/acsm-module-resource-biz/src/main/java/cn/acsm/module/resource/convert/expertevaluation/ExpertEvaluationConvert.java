package cn.acsm.module.resource.convert.expertevaluation;

import cn.acsm.module.resource.controller.admin.expertevaluation.vo.ExpertEvaluationCreateReqVO;
import cn.acsm.module.resource.controller.admin.expertevaluation.vo.ExpertEvaluationExcelVO;
import cn.acsm.module.resource.controller.admin.expertevaluation.vo.ExpertEvaluationRespVO;
import cn.acsm.module.resource.controller.admin.expertevaluation.vo.ExpertEvaluationUpdateReqVO;
import cn.acsm.module.resource.dal.dataobject.expertevaluation.ExpertEvaluationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 健康状况 Convert
 *
 * @author smile
 */
@Mapper
public interface ExpertEvaluationConvert {

    ExpertEvaluationConvert INSTANCE = Mappers.getMapper(ExpertEvaluationConvert.class);

    ExpertEvaluationDO convert(ExpertEvaluationCreateReqVO bean);

    ExpertEvaluationDO convert(ExpertEvaluationUpdateReqVO bean);

    ExpertEvaluationRespVO convert(ExpertEvaluationDO bean);

    List<ExpertEvaluationRespVO> convertList(List<ExpertEvaluationDO> list);

    PageResult<ExpertEvaluationRespVO> convertPage(PageResult<ExpertEvaluationDO> page);

    List<ExpertEvaluationExcelVO> convertList02(List<ExpertEvaluationDO> list);

}
