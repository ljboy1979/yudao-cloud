package cn.acsm.module.member.user.service.patienthealth;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.member.user.controller.admin.patient.vo.patienthealth.PatientHealthCreateReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.patienthealth.PatientHealthExportReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.patienthealth.PatientHealthPageReqVO;
import cn.acsm.module.member.user.controller.admin.patient.vo.patienthealth.PatientHealthUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.PatientHealthDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 健康档案 Service 接口
 *
 * @author lihongyan
 */
public interface PatientHealthService {

    /**
     * 创建健康档案
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPatientHealth(@Valid PatientHealthCreateReqVO createReqVO);

    /**
     * 更新健康档案
     *
     * @param updateReqVO 更新信息
     */
    void updatePatientHealth(@Valid PatientHealthUpdateReqVO updateReqVO);

    /**
     * 删除健康档案
     *
     * @param id 编号
     */
    void deletePatientHealth(Long id);

    /**
     * 获得健康档案
     *
     * @param id 编号
     * @return 健康档案
     */
    PatientHealthDO getPatientHealth(Long id);

    /**
     * 获得健康档案列表
     *
     * @param ids 编号
     * @return 健康档案列表
     */
    List<PatientHealthDO> getPatientHealthList(Collection<Long> ids);

    /**
     * 获得健康档案分页
     *
     * @param pageReqVO 分页查询
     * @return 健康档案分页
     */
    PageResult<PatientHealthDO> getPatientHealthPage(PatientHealthPageReqVO pageReqVO);

    /**
     * 获得健康档案列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 健康档案列表
     */
    List<PatientHealthDO> getPatientHealthList(PatientHealthExportReqVO exportReqVO);

}
