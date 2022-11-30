package cn.acsm.module.member.user.service.professional;

import cn.acsm.module.member.user.controller.admin.professional.vo.ProfessionalQualificationCreateReqVO;
import cn.acsm.module.member.user.controller.admin.professional.vo.ProfessionalQualificationExportReqVO;
import cn.acsm.module.member.user.controller.admin.professional.vo.ProfessionalQualificationPageReqVO;
import cn.acsm.module.member.user.controller.admin.professional.vo.ProfessionalQualificationUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.professional.ProfessionalQualificationDO;
import cn.acsm.module.member.user.dal.mysql.professional.ProfessionalQualificationMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.member.user.convert.professional.ProfessionalQualificationConvert;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.member.user.enums.ErrorCodeConstants.*;

/**
 * 专业资质 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class ProfessionalQualificationServiceImpl implements ProfessionalQualificationService {

    @Resource
    private ProfessionalQualificationMapper professionalQualificationMapper;

    @Override
    public Long createProfessionalQualification(ProfessionalQualificationCreateReqVO createReqVO) {
        // 插入
        ProfessionalQualificationDO professionalQualification = ProfessionalQualificationConvert.INSTANCE.convert(createReqVO);
        professionalQualificationMapper.insert(professionalQualification);
        // 返回
        return professionalQualification.getId();
    }

    @Override
    public void updateProfessionalQualification(ProfessionalQualificationUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateProfessionalQualificationExists(updateReqVO.getId());
        // 更新
        ProfessionalQualificationDO updateObj = ProfessionalQualificationConvert.INSTANCE.convert(updateReqVO);
        professionalQualificationMapper.updateById(updateObj);
    }

    @Override
    public void deleteProfessionalQualification(Long id) {
        // 校验存在
        this.validateProfessionalQualificationExists(id);
        // 删除
        professionalQualificationMapper.deleteById(id);
    }

    private void validateProfessionalQualificationExists(Long id) {
        if (professionalQualificationMapper.selectById(id) == null) {
            throw exception(PROFESSIONAL_QUALIFICATION_NOT_EXISTS);
        }
    }

    @Override
    public ProfessionalQualificationDO getProfessionalQualification(Long id) {
        return professionalQualificationMapper.selectById(id);
    }

    @Override
    public List<ProfessionalQualificationDO> getProfessionalQualificationList(Collection<Long> ids) {
        return professionalQualificationMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ProfessionalQualificationDO> getProfessionalQualificationPage(ProfessionalQualificationPageReqVO pageReqVO) {
        return professionalQualificationMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ProfessionalQualificationDO> getProfessionalQualificationList(ProfessionalQualificationExportReqVO exportReqVO) {
        return professionalQualificationMapper.selectList(exportReqVO);
    }

}
