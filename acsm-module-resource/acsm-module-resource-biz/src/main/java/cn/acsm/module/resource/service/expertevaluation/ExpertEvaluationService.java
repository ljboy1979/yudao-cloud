package cn.acsm.module.resource.service.expertevaluation;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.resource.controller.admin.expertevaluation.vo.ExpertEvaluationCreateReqVO;
import cn.acsm.module.resource.controller.admin.expertevaluation.vo.ExpertEvaluationExportReqVO;
import cn.acsm.module.resource.controller.admin.expertevaluation.vo.ExpertEvaluationPageReqVO;
import cn.acsm.module.resource.controller.admin.expertevaluation.vo.ExpertEvaluationUpdateReqVO;
import cn.acsm.module.resource.dal.dataobject.expertevaluation.ExpertEvaluationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 健康状况 Service 接口
 *
 * @author smile
 */
public interface ExpertEvaluationService {

    /**
     * 创建健康状况
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExpertEvaluation(@Valid ExpertEvaluationCreateReqVO createReqVO);

    /**
     * 更新健康状况
     *
     * @param updateReqVO 更新信息
     */
    void updateExpertEvaluation(@Valid ExpertEvaluationUpdateReqVO updateReqVO);

    /**
     * 删除健康状况
     *
     * @param id 编号
     */
    void deleteExpertEvaluation(Long id);

    /**
     * 获得健康状况
     *
     * @param id 编号
     * @return 健康状况
     */
    ExpertEvaluationDO getExpertEvaluation(Long id);

    /**
     * 获得健康状况列表
     *
     * @param ids 编号
     * @return 健康状况列表
     */
    List<ExpertEvaluationDO> getExpertEvaluationList(Collection<Long> ids);

    /**
     * 获得健康状况分页
     *
     * @param pageReqVO 分页查询
     * @return 健康状况分页
     */
    PageResult<ExpertEvaluationDO> getExpertEvaluationPage(ExpertEvaluationPageReqVO pageReqVO);

    /**
     * 获得健康状况列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 健康状况列表
     */
    List<ExpertEvaluationDO> getExpertEvaluationList(ExpertEvaluationExportReqVO exportReqVO);

}
