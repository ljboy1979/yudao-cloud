package cn.acsm.module.member.user.service.patienthealth;

import cn.acsm.module.member.user.controller.admin.patient.vo.hospitaladmission.HospitalAdmissionRecordCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.hospitaladmission.HospitalAdmissionRecordExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.hospitaladmission.HospitalAdmissionRecordPageReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.hospitaladmission.HospitalAdmissionRecordUpdateReqVO;
import cn.acsm.module.member.user.convert.patienthealth.HospitalAdmissionRecordConvert;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.HospitalAdmissionRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.member.user.dal.mysql.patienthealth.HospitalAdmissionRecordMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.member.user.enums.ErrorCodeConstants.*;

/**
 * 住院记录 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class HospitalAdmissionRecordServiceImpl implements HospitalAdmissionRecordService {

    @Resource
    private HospitalAdmissionRecordMapper hospitalAdmissionRecordMapper;

    @Override
    public Long createHospitalAdmissionRecord(HospitalAdmissionRecordCreateReqVO createReqVO) {
        // 插入
        HospitalAdmissionRecordDO hospitalAdmissionRecord = HospitalAdmissionRecordConvert.INSTANCE.convert(createReqVO);
        hospitalAdmissionRecordMapper.insert(hospitalAdmissionRecord);
        // 返回
        return hospitalAdmissionRecord.getId();
    }

    @Override
    public void updateHospitalAdmissionRecord(HospitalAdmissionRecordUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateHospitalAdmissionRecordExists(updateReqVO.getId());
        // 更新
        HospitalAdmissionRecordDO updateObj = HospitalAdmissionRecordConvert.INSTANCE.convert(updateReqVO);
        hospitalAdmissionRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteHospitalAdmissionRecord(Long id) {
        // 校验存在
        this.validateHospitalAdmissionRecordExists(id);
        // 删除
        hospitalAdmissionRecordMapper.deleteById(id);
    }

    private void validateHospitalAdmissionRecordExists(Long id) {
        if (hospitalAdmissionRecordMapper.selectById(id) == null) {
            throw exception(HOSPITAL_ADMISSION_RECORD_NOT_EXISTS);
        }
    }

    @Override
    public HospitalAdmissionRecordDO getHospitalAdmissionRecord(Long id) {
        return hospitalAdmissionRecordMapper.selectById(id);
    }

    @Override
    public List<HospitalAdmissionRecordDO> getHospitalAdmissionRecordList(Collection<Long> ids) {
        return hospitalAdmissionRecordMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<HospitalAdmissionRecordDO> getHospitalAdmissionRecordPage(HospitalAdmissionRecordPageReqVO pageReqVO) {
        return hospitalAdmissionRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<HospitalAdmissionRecordDO> getHospitalAdmissionRecordList(HospitalAdmissionRecordExportReqVO exportReqVO) {
        return hospitalAdmissionRecordMapper.selectList(exportReqVO);
    }

}
