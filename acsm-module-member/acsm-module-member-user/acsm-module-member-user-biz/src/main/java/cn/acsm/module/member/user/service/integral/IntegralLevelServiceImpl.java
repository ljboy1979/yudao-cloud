package cn.acsm.module.member.user.service.integral;

import cn.acsm.module.member.user.controller.admin.integral.vo.level.IntegralLevelCreateReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.level.IntegralLevelExportReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.level.IntegralLevelPageReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.level.IntegralLevelUpdateReqVO;
import cn.acsm.module.member.user.convert.integral.IntegralLevelConvert;
import cn.acsm.module.member.user.dal.dataobject.integral.IntegralLevelDO;
import cn.acsm.module.member.user.dal.mysql.integral.IntegralLevelMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.member.user.enums.ErrorCodeConstants.*;

/**
 * 会员积分等级 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class IntegralLevelServiceImpl implements IntegralLevelService {

    @Resource
    private IntegralLevelMapper integralLevelMapper;

    @Override
    public Long createIntegralLevel(IntegralLevelCreateReqVO createReqVO) {
        // 插入
        IntegralLevelDO integralLevel = IntegralLevelConvert.INSTANCE.convert(createReqVO);
        integralLevelMapper.insert(integralLevel);
        // 返回
        return integralLevel.getId();
    }

    @Override
    public void updateIntegralLevel(IntegralLevelUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateIntegralLevelExists(updateReqVO.getId());
        // 更新
        IntegralLevelDO updateObj = IntegralLevelConvert.INSTANCE.convert(updateReqVO);
        integralLevelMapper.updateById(updateObj);
    }

    @Override
    public void deleteIntegralLevel(Long id) {
        // 校验存在
        this.validateIntegralLevelExists(id);
        // 删除
        integralLevelMapper.deleteById(id);
    }

    private void validateIntegralLevelExists(Long id) {
        if (integralLevelMapper.selectById(id) == null) {
            throw exception(INTEGRAL_LEVEL_NOT_EXISTS);
        }
    }

    @Override
    public IntegralLevelDO getIntegralLevel(Long id) {
        return integralLevelMapper.selectById(id);
    }

    @Override
    public List<IntegralLevelDO> getIntegralLevelList(Collection<Long> ids) {
        return integralLevelMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<IntegralLevelDO> getIntegralLevelPage(IntegralLevelPageReqVO pageReqVO) {
        return integralLevelMapper.selectPage(pageReqVO);
    }

    @Override
    public List<IntegralLevelDO> getIntegralLevelList(IntegralLevelExportReqVO exportReqVO) {
        return integralLevelMapper.selectList(exportReqVO);
    }

}
