package cn.acsm.module.member.user.service.patienthealth;

import cn.acsm.module.member.user.controller.admin.patient.vo.medical.MedicalRecordCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medical.MedicalRecordExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medical.MedicalRecordPageReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medical.MedicalRecordUpdateReqVO;
import cn.acsm.module.member.user.convert.patienthealth.MedicalRecordConvert;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.MedicalRecordDO;
import cn.acsm.module.member.user.dal.mysql.patienthealth.MedicalRecordMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.member.user.enums.ErrorCodeConstants.*;

/**
 * 医嘱记录 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Resource
    private MedicalRecordMapper medicalRecordMapper;

    @Override
    public Long createMedicalRecord(MedicalRecordCreateReqVO createReqVO) {
        // 插入
        MedicalRecordDO medicalRecord = MedicalRecordConvert.INSTANCE.convert(createReqVO);
        medicalRecordMapper.insert(medicalRecord);
        // 返回
        return medicalRecord.getId();
    }

    @Override
    public void updateMedicalRecord(MedicalRecordUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateMedicalRecordExists(updateReqVO.getId());
        // 更新
        MedicalRecordDO updateObj = MedicalRecordConvert.INSTANCE.convert(updateReqVO);
        medicalRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteMedicalRecord(Long id) {
        // 校验存在
        this.validateMedicalRecordExists(id);
        // 删除
        medicalRecordMapper.deleteById(id);
    }

    private void validateMedicalRecordExists(Long id) {
        if (medicalRecordMapper.selectById(id) == null) {
            throw exception(MEDICAL_RECORD_NOT_EXISTS);
        }
    }

    @Override
    public MedicalRecordDO getMedicalRecord(Long id) {
        return medicalRecordMapper.selectById(id);
    }

    @Override
    public List<MedicalRecordDO> getMedicalRecordList(Collection<Long> ids) {
        return medicalRecordMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MedicalRecordDO> getMedicalRecordPage(MedicalRecordPageReqVO pageReqVO) {
        return medicalRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MedicalRecordDO> getMedicalRecordList(MedicalRecordExportReqVO exportReqVO) {
        return medicalRecordMapper.selectList(exportReqVO);
    }

}
