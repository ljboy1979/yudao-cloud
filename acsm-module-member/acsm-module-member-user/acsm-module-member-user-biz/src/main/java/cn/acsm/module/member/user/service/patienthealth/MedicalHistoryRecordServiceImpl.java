package cn.acsm.module.member.user.service.patienthealth;

import cn.acsm.module.member.user.controller.admin.patient.vo.medicalhistory.MedicalHistoryRecordCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medicalhistory.MedicalHistoryRecordExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medicalhistory.MedicalHistoryRecordPageReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medicalhistory.MedicalHistoryRecordUpdateReqVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.MedicalHistoryRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.member.user.convert.patienthealth.MedicalHistoryRecordConvert;
import cn.acsm.module.member.user.dal.mysql.patienthealth.MedicalHistoryRecordMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.member.user.enums.ErrorCodeConstants.*;

/**
 * 病史记录 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class MedicalHistoryRecordServiceImpl implements MedicalHistoryRecordService {

    @Resource
    private MedicalHistoryRecordMapper medicalHistoryRecordMapper;

    @Override
    public Long createMedicalHistoryRecord(MedicalHistoryRecordCreateReqVO createReqVO) {
        // 插入
        MedicalHistoryRecordDO medicalHistoryRecord = MedicalHistoryRecordConvert.INSTANCE.convert(createReqVO);
        medicalHistoryRecordMapper.insert(medicalHistoryRecord);
        // 返回
        return medicalHistoryRecord.getId();
    }

    @Override
    public void updateMedicalHistoryRecord(MedicalHistoryRecordUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateMedicalHistoryRecordExists(updateReqVO.getId());
        // 更新
        MedicalHistoryRecordDO updateObj = MedicalHistoryRecordConvert.INSTANCE.convert(updateReqVO);
        medicalHistoryRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteMedicalHistoryRecord(Long id) {
        // 校验存在
        this.validateMedicalHistoryRecordExists(id);
        // 删除
        medicalHistoryRecordMapper.deleteById(id);
    }

    private void validateMedicalHistoryRecordExists(Long id) {
        if (medicalHistoryRecordMapper.selectById(id) == null) {
            throw exception(MEDICAL_HISTORY_RECORD_NOT_EXISTS);
        }
    }

    @Override
    public MedicalHistoryRecordDO getMedicalHistoryRecord(Long id) {
        return medicalHistoryRecordMapper.selectById(id);
    }

    @Override
    public List<MedicalHistoryRecordDO> getMedicalHistoryRecordList(Collection<Long> ids) {
        return medicalHistoryRecordMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MedicalHistoryRecordDO> getMedicalHistoryRecordPage(MedicalHistoryRecordPageReqVO pageReqVO) {
        return medicalHistoryRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MedicalHistoryRecordDO> getMedicalHistoryRecordList(MedicalHistoryRecordExportReqVO exportReqVO) {
        return medicalHistoryRecordMapper.selectList(exportReqVO);
    }

}
