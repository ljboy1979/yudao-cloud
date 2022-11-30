package cn.acsm.module.member.user.service.patienthealth;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.member.user.controller.admin.patient.vo.medicalhistory.MedicalHistoryRecordCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medicalhistory.MedicalHistoryRecordExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medicalhistory.MedicalHistoryRecordPageReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medicalhistory.MedicalHistoryRecordUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.MedicalHistoryRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 病史记录 Service 接口
 *
 * @author lihongyan
 */
public interface MedicalHistoryRecordService {

    /**
     * 创建病史记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createMedicalHistoryRecord(@Valid MedicalHistoryRecordCreateReqVO createReqVO);

    /**
     * 更新病史记录
     *
     * @param updateReqVO 更新信息
     */
    void updateMedicalHistoryRecord(@Valid MedicalHistoryRecordUpdateReqVO updateReqVO);

    /**
     * 删除病史记录
     *
     * @param id 编号
     */
    void deleteMedicalHistoryRecord(Long id);

    /**
     * 获得病史记录
     *
     * @param id 编号
     * @return 病史记录
     */
    MedicalHistoryRecordDO getMedicalHistoryRecord(Long id);

    /**
     * 获得病史记录列表
     *
     * @param ids 编号
     * @return 病史记录列表
     */
    List<MedicalHistoryRecordDO> getMedicalHistoryRecordList(Collection<Long> ids);

    /**
     * 获得病史记录分页
     *
     * @param pageReqVO 分页查询
     * @return 病史记录分页
     */
    PageResult<MedicalHistoryRecordDO> getMedicalHistoryRecordPage(MedicalHistoryRecordPageReqVO pageReqVO);

    /**
     * 获得病史记录列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 病史记录列表
     */
    List<MedicalHistoryRecordDO> getMedicalHistoryRecordList(MedicalHistoryRecordExportReqVO exportReqVO);

}
