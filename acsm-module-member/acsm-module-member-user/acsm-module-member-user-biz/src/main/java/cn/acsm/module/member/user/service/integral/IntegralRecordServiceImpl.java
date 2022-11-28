package cn.acsm.module.member.user.service.integral;

import cn.acsm.module.member.user.controller.admin.integral.vo.record.IntegralRecordCreateReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.record.IntegralRecordExportReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.record.IntegralRecordPageReqVO;
import cn.acsm.module.member.user.controller.admin.integral.vo.record.IntegralRecordUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.integral.IntegralRecordDO;
import cn.acsm.module.member.user.dal.mysql.integral.IntegralRecordMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.member.user.convert.integral.IntegralRecordConvert;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.member.user.enums.ErrorCodeConstants.*;

/**
 * 会员积分记录 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class IntegralRecordServiceImpl implements IntegralRecordService {

    @Resource
    private IntegralRecordMapper integralRecordMapper;

    @Override
    public Long createIntegralRecord(IntegralRecordCreateReqVO createReqVO) {
        // 插入
        IntegralRecordDO integralRecord = IntegralRecordConvert.INSTANCE.convert(createReqVO);
        integralRecordMapper.insert(integralRecord);
        // 返回
        return integralRecord.getId();
    }

    @Override
    public void updateIntegralRecord(IntegralRecordUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateIntegralRecordExists(updateReqVO.getId());
        // 更新
        IntegralRecordDO updateObj = IntegralRecordConvert.INSTANCE.convert(updateReqVO);
        integralRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteIntegralRecord(Long id) {
        // 校验存在
        this.validateIntegralRecordExists(id);
        // 删除
        integralRecordMapper.deleteById(id);
    }

    private void validateIntegralRecordExists(Long id) {
        if (integralRecordMapper.selectById(id) == null) {
            throw exception(INTEGRAL_RECORD_NOT_EXISTS);
        }
    }

    @Override
    public IntegralRecordDO getIntegralRecord(Long id) {
        return integralRecordMapper.selectById(id);
    }

    @Override
    public List<IntegralRecordDO> getIntegralRecordList(Collection<Long> ids) {
        return integralRecordMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<IntegralRecordDO> getIntegralRecordPage(IntegralRecordPageReqVO pageReqVO) {
        return integralRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<IntegralRecordDO> getIntegralRecordList(IntegralRecordExportReqVO exportReqVO) {
        return integralRecordMapper.selectList(exportReqVO);
    }

}
