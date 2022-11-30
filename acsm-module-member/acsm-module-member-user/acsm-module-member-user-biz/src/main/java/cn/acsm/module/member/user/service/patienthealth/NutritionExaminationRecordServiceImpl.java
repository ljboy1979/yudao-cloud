package cn.acsm.module.member.user.service.patienthealth;

import cn.acsm.module.member.user.controller.admin.patient.vo.nutritionexamination.NutritionExaminationRecordCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.nutritionexamination.NutritionExaminationRecordExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.nutritionexamination.NutritionExaminationRecordPageReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.nutritionexamination.NutritionExaminationRecordUpdateReqVO;
import cn.acsm.module.member.user.convert.patienthealth.NutritionExaminationRecordConvert;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.NutritionExaminationRecordDO;
import cn.acsm.module.member.user.dal.mysql.patienthealth.NutritionExaminationRecordMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.member.user.enums.ErrorCodeConstants.*;

/**
 * 营养检查记录 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class NutritionExaminationRecordServiceImpl implements NutritionExaminationRecordService {

    @Resource
    private NutritionExaminationRecordMapper nutritionExaminationRecordMapper;

    @Override
    public Long createNutritionExaminationRecord(NutritionExaminationRecordCreateReqVO createReqVO) {
        // 插入
        NutritionExaminationRecordDO nutritionExaminationRecord = NutritionExaminationRecordConvert.INSTANCE.convert(createReqVO);
        nutritionExaminationRecordMapper.insert(nutritionExaminationRecord);
        // 返回
        return nutritionExaminationRecord.getId();
    }

    @Override
    public void updateNutritionExaminationRecord(NutritionExaminationRecordUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateNutritionExaminationRecordExists(updateReqVO.getId());
        // 更新
        NutritionExaminationRecordDO updateObj = NutritionExaminationRecordConvert.INSTANCE.convert(updateReqVO);
        nutritionExaminationRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteNutritionExaminationRecord(Long id) {
        // 校验存在
        this.validateNutritionExaminationRecordExists(id);
        // 删除
        nutritionExaminationRecordMapper.deleteById(id);
    }

    private void validateNutritionExaminationRecordExists(Long id) {
        if (nutritionExaminationRecordMapper.selectById(id) == null) {
            throw exception(NUTRITION_EXAMINATION_RECORD_NOT_EXISTS);
        }
    }

    @Override
    public NutritionExaminationRecordDO getNutritionExaminationRecord(Long id) {
        return nutritionExaminationRecordMapper.selectById(id);
    }

    @Override
    public List<NutritionExaminationRecordDO> getNutritionExaminationRecordList(Collection<Long> ids) {
        return nutritionExaminationRecordMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<NutritionExaminationRecordDO> getNutritionExaminationRecordPage(NutritionExaminationRecordPageReqVO pageReqVO) {
        return nutritionExaminationRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<NutritionExaminationRecordDO> getNutritionExaminationRecordList(NutritionExaminationRecordExportReqVO exportReqVO) {
        return nutritionExaminationRecordMapper.selectList(exportReqVO);
    }

}
