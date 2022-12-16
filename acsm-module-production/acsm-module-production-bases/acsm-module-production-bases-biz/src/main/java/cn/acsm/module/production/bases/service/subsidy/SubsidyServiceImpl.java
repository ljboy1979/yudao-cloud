package cn.acsm.module.production.bases.service.subsidy;

import cn.acsm.module.production.bases.controller.admin.subsidy.vo.SubsidyCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.subsidy.vo.SubsidyExportReqVO;
import cn.acsm.module.production.bases.controller.admin.subsidy.vo.SubsidyPageReqVO;
import cn.acsm.module.production.bases.controller.admin.subsidy.vo.SubsidyUpdateReqVO;
import cn.acsm.module.production.bases.convert.subsidy.SubsidyConvert;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.production.bases.controller.admin.subsidy.vo.*;
import cn.acsm.module.production.bases.dal.dataobject.subsidy.SubsidyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.production.bases.dal.mysql.subsidy.SubsidyMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.production.bases.enums.ErrorCodeConstants.*;

/**
 * 基地补贴信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class SubsidyServiceImpl implements SubsidyService {

    @Resource
    private SubsidyMapper subsidyMapper;

    @Override
    public Long createSubsidy(SubsidyCreateReqVO createReqVO) {
        // 插入
        SubsidyDO subsidy = SubsidyConvert.INSTANCE.convert(createReqVO);
        subsidyMapper.insert(subsidy);
        // 返回
        return subsidy.getId();
    }

    @Override
    public void updateSubsidy(SubsidyUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateSubsidyExists(updateReqVO.getId());
        // 更新
        SubsidyDO updateObj = SubsidyConvert.INSTANCE.convert(updateReqVO);
        subsidyMapper.updateById(updateObj);
    }

    @Override
    public void deleteSubsidy(Long id) {
        // 校验存在
        this.validateSubsidyExists(id);
        // 删除
        subsidyMapper.deleteById(id);
    }

    private void validateSubsidyExists(Long id) {
        if (subsidyMapper.selectById(id) == null) {
            throw exception(SUBSIDY_NOT_EXISTS);
        }
    }

    @Override
    public SubsidyDO getSubsidy(Long id) {
        return subsidyMapper.selectById(id);
    }

    @Override
    public List<SubsidyDO> getSubsidyList(Collection<Long> ids) {
        return subsidyMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<SubsidyDO> getSubsidyPage(SubsidyPageReqVO pageReqVO) {
        return subsidyMapper.selectPage(pageReqVO);
    }

    @Override
    public List<SubsidyDO> getSubsidyList(SubsidyExportReqVO exportReqVO) {
        return subsidyMapper.selectList(exportReqVO);
    }

}
