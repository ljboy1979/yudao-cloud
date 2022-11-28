package cn.acsm.module.member.user.service.professional;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.member.user.controller.admin.professional.vo.ProfessionalQualificationCreateReqVO;
import cn.acsm.module.member.user.controller.admin.professional.vo.ProfessionalQualificationExportReqVO;
import cn.acsm.module.member.user.controller.admin.professional.vo.ProfessionalQualificationPageReqVO;
import cn.acsm.module.member.user.controller.admin.professional.vo.ProfessionalQualificationUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.professional.ProfessionalQualificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 专业资质 Service 接口
 *
 * @author lihongyan
 */
public interface ProfessionalQualificationService {

    /**
     * 创建专业资质
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createProfessionalQualification(@Valid ProfessionalQualificationCreateReqVO createReqVO);

    /**
     * 更新专业资质
     *
     * @param updateReqVO 更新信息
     */
    void updateProfessionalQualification(@Valid ProfessionalQualificationUpdateReqVO updateReqVO);

    /**
     * 删除专业资质
     *
     * @param id 编号
     */
    void deleteProfessionalQualification(Long id);

    /**
     * 获得专业资质
     *
     * @param id 编号
     * @return 专业资质
     */
    ProfessionalQualificationDO getProfessionalQualification(Long id);

    /**
     * 获得专业资质列表
     *
     * @param ids 编号
     * @return 专业资质列表
     */
    List<ProfessionalQualificationDO> getProfessionalQualificationList(Collection<Long> ids);

    /**
     * 获得专业资质分页
     *
     * @param pageReqVO 分页查询
     * @return 专业资质分页
     */
    PageResult<ProfessionalQualificationDO> getProfessionalQualificationPage(ProfessionalQualificationPageReqVO pageReqVO);

    /**
     * 获得专业资质列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 专业资质列表
     */
    List<ProfessionalQualificationDO> getProfessionalQualificationList(ProfessionalQualificationExportReqVO exportReqVO);

}
