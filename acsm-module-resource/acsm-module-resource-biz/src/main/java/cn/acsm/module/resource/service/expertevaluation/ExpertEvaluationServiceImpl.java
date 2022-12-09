package cn.acsm.module.resource.service.expertevaluation;

import cn.acsm.module.resource.controller.admin.expertevaluation.vo.ExpertEvaluationCreateReqVO;
import cn.acsm.module.resource.controller.admin.expertevaluation.vo.ExpertEvaluationExportReqVO;
import cn.acsm.module.resource.controller.admin.expertevaluation.vo.ExpertEvaluationPageReqVO;
import cn.acsm.module.resource.controller.admin.expertevaluation.vo.ExpertEvaluationUpdateReqVO;
import cn.acsm.module.resource.dal.mysql.expertevaluation.ExpertEvaluationMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.resource.dal.dataobject.expertevaluation.ExpertEvaluationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.resource.convert.expertevaluation.ExpertEvaluationConvert;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.resource.enums.ErrorCodeConstants.*;

/**
 * 健康状况 Service 实现类
 *
 * @author smile
 */
@Service
@Validated
@Transactional(readOnly = false)
public class ExpertEvaluationServiceImpl implements ExpertEvaluationService {

    @Resource
    private ExpertEvaluationMapper expertEvaluationMapper;

    @Override
    public Long createExpertEvaluation(ExpertEvaluationCreateReqVO createReqVO) {
        // 插入
        ExpertEvaluationDO expertEvaluation = ExpertEvaluationConvert.INSTANCE.convert(createReqVO);
        expertEvaluationMapper.insert(expertEvaluation);
        // 返回
        return expertEvaluation.getId();
    }

    @Override
    public void updateExpertEvaluation(ExpertEvaluationUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateExpertEvaluationExists(updateReqVO.getId());
        // 更新
        ExpertEvaluationDO updateObj = ExpertEvaluationConvert.INSTANCE.convert(updateReqVO);
        expertEvaluationMapper.updateById(updateObj);
    }

    @Override
    public void deleteExpertEvaluation(Long id) {
        // 校验存在
        this.validateExpertEvaluationExists(id);
        // 删除
        expertEvaluationMapper.deleteById(id);
    }

    private void validateExpertEvaluationExists(Long id) {
        if (expertEvaluationMapper.selectById(id) == null) {
            throw exception(EXPERT_EVALUATION_NOT_EXISTS);
        }
    }

    @Override
    public ExpertEvaluationDO getExpertEvaluation(Long id) {
        return expertEvaluationMapper.selectById(id);
    }

    @Override
    public List<ExpertEvaluationDO> getExpertEvaluationList(Collection<Long> ids) {
        return expertEvaluationMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ExpertEvaluationDO> getExpertEvaluationPage(ExpertEvaluationPageReqVO pageReqVO) {
        return expertEvaluationMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ExpertEvaluationDO> getExpertEvaluationList(ExpertEvaluationExportReqVO exportReqVO) {
        return expertEvaluationMapper.selectList(exportReqVO);
    }

}
