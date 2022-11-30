package cn.acsm.module.member.user.service.patienthealth;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.member.user.controller.admin.patient.vo.nutritionexamination.NutritionExaminationRecordCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.nutritionexamination.NutritionExaminationRecordExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.nutritionexamination.NutritionExaminationRecordPageReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.nutritionexamination.NutritionExaminationRecordUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.NutritionExaminationRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 营养检查记录 Service 接口
 *
 * @author lihongyan
 */
public interface NutritionExaminationRecordService {

    /**
     * 创建营养检查记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createNutritionExaminationRecord(@Valid NutritionExaminationRecordCreateReqVO createReqVO);

    /**
     * 更新营养检查记录
     *
     * @param updateReqVO 更新信息
     */
    void updateNutritionExaminationRecord(@Valid NutritionExaminationRecordUpdateReqVO updateReqVO);

    /**
     * 删除营养检查记录
     *
     * @param id 编号
     */
    void deleteNutritionExaminationRecord(Long id);

    /**
     * 获得营养检查记录
     *
     * @param id 编号
     * @return 营养检查记录
     */
    NutritionExaminationRecordDO getNutritionExaminationRecord(Long id);

    /**
     * 获得营养检查记录列表
     *
     * @param ids 编号
     * @return 营养检查记录列表
     */
    List<NutritionExaminationRecordDO> getNutritionExaminationRecordList(Collection<Long> ids);

    /**
     * 获得营养检查记录分页
     *
     * @param pageReqVO 分页查询
     * @return 营养检查记录分页
     */
    PageResult<NutritionExaminationRecordDO> getNutritionExaminationRecordPage(NutritionExaminationRecordPageReqVO pageReqVO);

    /**
     * 获得营养检查记录列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 营养检查记录列表
     */
    List<NutritionExaminationRecordDO> getNutritionExaminationRecordList(NutritionExaminationRecordExportReqVO exportReqVO);

}
