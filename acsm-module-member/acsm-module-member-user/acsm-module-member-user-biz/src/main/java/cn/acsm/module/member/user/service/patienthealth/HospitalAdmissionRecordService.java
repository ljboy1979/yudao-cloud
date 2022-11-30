package cn.acsm.module.member.user.service.patienthealth;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.member.user.controller.admin.patient.vo.hospitaladmission.HospitalAdmissionRecordCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.hospitaladmission.HospitalAdmissionRecordExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.hospitaladmission.HospitalAdmissionRecordPageReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.hospitaladmission.HospitalAdmissionRecordUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.HospitalAdmissionRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 住院记录 Service 接口
 *
 * @author lihongyan
 */
public interface HospitalAdmissionRecordService {

    /**
     * 创建住院记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createHospitalAdmissionRecord(@Valid HospitalAdmissionRecordCreateReqVO createReqVO);

    /**
     * 更新住院记录
     *
     * @param updateReqVO 更新信息
     */
    void updateHospitalAdmissionRecord(@Valid HospitalAdmissionRecordUpdateReqVO updateReqVO);

    /**
     * 删除住院记录
     *
     * @param id 编号
     */
    void deleteHospitalAdmissionRecord(Long id);

    /**
     * 获得住院记录
     *
     * @param id 编号
     * @return 住院记录
     */
    HospitalAdmissionRecordDO getHospitalAdmissionRecord(Long id);

    /**
     * 获得住院记录列表
     *
     * @param ids 编号
     * @return 住院记录列表
     */
    List<HospitalAdmissionRecordDO> getHospitalAdmissionRecordList(Collection<Long> ids);

    /**
     * 获得住院记录分页
     *
     * @param pageReqVO 分页查询
     * @return 住院记录分页
     */
    PageResult<HospitalAdmissionRecordDO> getHospitalAdmissionRecordPage(HospitalAdmissionRecordPageReqVO pageReqVO);

    /**
     * 获得住院记录列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 住院记录列表
     */
    List<HospitalAdmissionRecordDO> getHospitalAdmissionRecordList(HospitalAdmissionRecordExportReqVO exportReqVO);

}
