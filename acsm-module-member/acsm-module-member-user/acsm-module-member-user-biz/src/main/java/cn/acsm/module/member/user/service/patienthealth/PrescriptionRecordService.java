package cn.acsm.module.member.user.service.patienthealth;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.member.user.controller.admin.patient.vo.prescription.PrescriptionRecordCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.prescription.PrescriptionRecordExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.prescription.PrescriptionRecordPageReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.prescription.PrescriptionRecordUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.PrescriptionRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 处方记录表 Service 接口
 *
 * @author lihongyan
 */
public interface PrescriptionRecordService {

    /**
     * 创建处方记录表
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPrescriptionRecord(@Valid PrescriptionRecordCreateReqVO createReqVO);

    /**
     * 更新处方记录表
     *
     * @param updateReqVO 更新信息
     */
    void updatePrescriptionRecord(@Valid PrescriptionRecordUpdateReqVO updateReqVO);

    /**
     * 删除处方记录表
     *
     * @param id 编号
     */
    void deletePrescriptionRecord(Long id);

    /**
     * 获得处方记录表
     *
     * @param id 编号
     * @return 处方记录表
     */
    PrescriptionRecordDO getPrescriptionRecord(Long id);

    /**
     * 获得处方记录表列表
     *
     * @param ids 编号
     * @return 处方记录表列表
     */
    List<PrescriptionRecordDO> getPrescriptionRecordList(Collection<Long> ids);

    /**
     * 获得处方记录表分页
     *
     * @param pageReqVO 分页查询
     * @return 处方记录表分页
     */
    PageResult<PrescriptionRecordDO> getPrescriptionRecordPage(PrescriptionRecordPageReqVO pageReqVO);

    /**
     * 获得处方记录表列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 处方记录表列表
     */
    List<PrescriptionRecordDO> getPrescriptionRecordList(PrescriptionRecordExportReqVO exportReqVO);

}
