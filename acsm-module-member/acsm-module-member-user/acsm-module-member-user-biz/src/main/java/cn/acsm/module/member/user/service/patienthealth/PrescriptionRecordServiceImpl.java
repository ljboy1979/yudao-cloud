package cn.acsm.module.member.user.service.patienthealth;

import cn.acsm.module.member.user.controller.admin.patient.vo.prescription.PrescriptionRecordCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.prescription.PrescriptionRecordExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.prescription.PrescriptionRecordPageReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.prescription.PrescriptionRecordUpdateReqVO;
import cn.acsm.module.member.user.dal.mysql.patienthealth.PrescriptionRecordMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.PrescriptionRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.member.user.convert.patienthealth.PrescriptionRecordConvert;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.member.user.enums.ErrorCodeConstants.*;

/**
 * 处方记录表 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class PrescriptionRecordServiceImpl implements PrescriptionRecordService {

    @Resource
    private PrescriptionRecordMapper prescriptionRecordMapper;

    @Override
    public Long createPrescriptionRecord(PrescriptionRecordCreateReqVO createReqVO) {
        // 插入
        PrescriptionRecordDO prescriptionRecord = PrescriptionRecordConvert.INSTANCE.convert(createReqVO);
        prescriptionRecordMapper.insert(prescriptionRecord);
        // 返回
        return prescriptionRecord.getId();
    }

    @Override
    public void updatePrescriptionRecord(PrescriptionRecordUpdateReqVO updateReqVO) {
        // 校验存在
        this.validatePrescriptionRecordExists(updateReqVO.getId());
        // 更新
        PrescriptionRecordDO updateObj = PrescriptionRecordConvert.INSTANCE.convert(updateReqVO);
        prescriptionRecordMapper.updateById(updateObj);
    }

    @Override
    public void deletePrescriptionRecord(Long id) {
        // 校验存在
        this.validatePrescriptionRecordExists(id);
        // 删除
        prescriptionRecordMapper.deleteById(id);
    }

    private void validatePrescriptionRecordExists(Long id) {
        if (prescriptionRecordMapper.selectById(id) == null) {
            throw exception(PRESCRIPTION_RECORD_NOT_EXISTS);
        }
    }

    @Override
    public PrescriptionRecordDO getPrescriptionRecord(Long id) {
        return prescriptionRecordMapper.selectById(id);
    }

    @Override
    public List<PrescriptionRecordDO> getPrescriptionRecordList(Collection<Long> ids) {
        return prescriptionRecordMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PrescriptionRecordDO> getPrescriptionRecordPage(PrescriptionRecordPageReqVO pageReqVO) {
        return prescriptionRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PrescriptionRecordDO> getPrescriptionRecordList(PrescriptionRecordExportReqVO exportReqVO) {
        return prescriptionRecordMapper.selectList(exportReqVO);
    }

}
