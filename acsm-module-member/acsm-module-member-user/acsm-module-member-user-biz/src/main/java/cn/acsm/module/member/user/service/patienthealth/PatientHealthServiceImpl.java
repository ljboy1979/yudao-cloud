package cn.acsm.module.member.user.service.patienthealth;

import cn.acsm.module.member.user.controller.admin.patient.vo.patienthealth.PatientHealthCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.patienthealth.PatientHealthExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.patienthealth.PatientHealthPageReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.patienthealth.PatientHealthUpdateReqVO;
import cn.acsm.module.member.user.dal.mysql.patienthealth.PatientHealthMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.PatientHealthDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.member.user.convert.patienthealth.PatientHealthConvert;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.member.user.enums.ErrorCodeConstants.*;

/**
 * 健康档案 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class PatientHealthServiceImpl implements PatientHealthService {

    @Resource
    private PatientHealthMapper patientHealthMapper;

    @Override
    public Long createPatientHealth(PatientHealthCreateReqVO createReqVO) {
        // 插入
        PatientHealthDO patientHealth = PatientHealthConvert.INSTANCE.convert(createReqVO);
        patientHealthMapper.insert(patientHealth);
        // 返回
        return patientHealth.getId();
    }

    @Override
    public void updatePatientHealth(PatientHealthUpdateReqVO updateReqVO) {
        // 校验存在
        this.validatePatientHealthExists(updateReqVO.getId());
        // 更新
        PatientHealthDO updateObj = PatientHealthConvert.INSTANCE.convert(updateReqVO);
        patientHealthMapper.updateById(updateObj);
    }

    @Override
    public void deletePatientHealth(Long id) {
        // 校验存在
        this.validatePatientHealthExists(id);
        // 删除
        patientHealthMapper.deleteById(id);
    }

    private void validatePatientHealthExists(Long id) {
        if (patientHealthMapper.selectById(id) == null) {
            throw exception(PATIENT_HEALTH_NOT_EXISTS);
        }
    }

    @Override
    public PatientHealthDO getPatientHealth(Long id) {
        return patientHealthMapper.selectById(id);
    }

    @Override
    public List<PatientHealthDO> getPatientHealthList(Collection<Long> ids) {
        return patientHealthMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PatientHealthDO> getPatientHealthPage(PatientHealthPageReqVO pageReqVO) {
        return patientHealthMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PatientHealthDO> getPatientHealthList(PatientHealthExportReqVO exportReqVO) {
        return patientHealthMapper.selectList(exportReqVO);
    }

}
