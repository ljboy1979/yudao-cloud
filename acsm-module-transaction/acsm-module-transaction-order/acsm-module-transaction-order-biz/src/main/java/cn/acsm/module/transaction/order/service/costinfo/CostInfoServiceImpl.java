package cn.acsm.module.transaction.order.service.costinfo;

import cn.acsm.module.transaction.order.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.order.controller.admin.costinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.costinfo.CostInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.order.convert.costinfo.CostInfoConvert;
import cn.acsm.module.transaction.order.dal.mysql.costinfo.CostInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.order.enums.ErrorCodeConstants.*;

/**
 * 费用 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class CostInfoServiceImpl implements CostInfoService {

    @Resource
    private CostInfoMapper costInfoMapper;
    @Resource
    private ConfigNumberUtil configNumberUtil;
    @Override
    public String createCostInfo(CostInfoCreateReqVO createReqVO) {
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("order_cost_info"+tenantId);
        // 插入
        CostInfoDO costInfo = CostInfoConvert.INSTANCE.convert(createReqVO);
        costInfo.setId(UUID.randomUUID().toString());
        costInfo.setCostNumber("YJ"+number);
        costInfoMapper.insert(costInfo);
        // 返回
        return costInfo.getId();
    }

    @Override
    public void updateCostInfo(CostInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateCostInfoExists(updateReqVO.getId());
        // 更新
        CostInfoDO updateObj = CostInfoConvert.INSTANCE.convert(updateReqVO);
        costInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteCostInfo(String id) {
        // 校验存在
        this.validateCostInfoExists(id);
        // 删除
        costInfoMapper.deleteById(id);
    }

    private void validateCostInfoExists(String id) {
        if (costInfoMapper.selectById(id) == null) {
            throw exception(COST_INFO_NOT_EXISTS);
        }
    }

    @Override
    public CostInfoDO getCostInfo(String id) {
        return costInfoMapper.selectById(id);
    }

    @Override
    public List<CostInfoDO> getCostInfoList(Collection<String> ids) {
        return costInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<CostInfoDO> getCostInfoPage(CostInfoPageReqVO pageReqVO) {
        return costInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CostInfoDO> getCostInfoList(CostInfoExportReqVO exportReqVO) {
        return costInfoMapper.selectList(exportReqVO);
    }

}
