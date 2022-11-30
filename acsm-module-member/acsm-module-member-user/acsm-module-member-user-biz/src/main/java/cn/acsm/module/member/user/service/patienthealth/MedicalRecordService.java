package cn.acsm.module.member.user.service.patienthealth;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.member.user.controller.admin.patient.vo.medical.MedicalRecordCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medical.MedicalRecordExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medical.MedicalRecordPageReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.medical.MedicalRecordUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.MedicalRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 医嘱记录 Service 接口
 *
 * @author lihongyan
 */
public interface MedicalRecordService {

    /**
     * 创建医嘱记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createMedicalRecord(@Valid MedicalRecordCreateReqVO createReqVO);

    /**
     * 更新医嘱记录
     *
     * @param updateReqVO 更新信息
     */
    void updateMedicalRecord(@Valid MedicalRecordUpdateReqVO updateReqVO);

    /**
     * 删除医嘱记录
     *
     * @param id 编号
     */
    void deleteMedicalRecord(Long id);

    /**
     * 获得医嘱记录
     *
     * @param id 编号
     * @return 医嘱记录
     */
    MedicalRecordDO getMedicalRecord(Long id);

    /**
     * 获得医嘱记录列表
     *
     * @param ids 编号
     * @return 医嘱记录列表
     */
    List<MedicalRecordDO> getMedicalRecordList(Collection<Long> ids);

    /**
     * 获得医嘱记录分页
     *
     * @param pageReqVO 分页查询
     * @return 医嘱记录分页
     */
    PageResult<MedicalRecordDO> getMedicalRecordPage(MedicalRecordPageReqVO pageReqVO);

    /**
     * 获得医嘱记录列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 医嘱记录列表
     */
    List<MedicalRecordDO> getMedicalRecordList(MedicalRecordExportReqVO exportReqVO);

}
