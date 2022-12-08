package cn.acsm.module.transaction.order.service.settleinfo;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.order.controller.admin.settleinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.settleinfo.SettleInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.order.convert.settleinfo.SettleInfoConvert;
import cn.acsm.module.transaction.order.dal.mysql.settleinfo.SettleInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.order.enums.ErrorCodeConstants.*;

/**
 * 订单结账 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class SettleInfoServiceImpl implements SettleInfoService {

    @Resource
    private SettleInfoMapper settleInfoMapper;

    @Override
    public String createSettleInfo(SettleInfoCreateReqVO createReqVO) {
        // 插入
        SettleInfoDO settleInfo = SettleInfoConvert.INSTANCE.convert(createReqVO);
        settleInfoMapper.insert(settleInfo);
        // 返回
        return settleInfo.getId();
    }

    @Override
    public void updateSettleInfo(SettleInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateSettleInfoExists(updateReqVO.getId());
        // 更新
        SettleInfoDO updateObj = SettleInfoConvert.INSTANCE.convert(updateReqVO);
        settleInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteSettleInfo(String id) {
        // 校验存在
        this.validateSettleInfoExists(id);
        // 删除
        settleInfoMapper.deleteById(id);
    }

    private void validateSettleInfoExists(String id) {
        if (settleInfoMapper.selectById(id) == null) {
            throw exception(SETTLE_INFO_NOT_EXISTS);
        }
    }

    @Override
    public SettleInfoDO getSettleInfo(String id) {
        return settleInfoMapper.selectById(id);
    }

    @Override
    public List<SettleInfoDO> getSettleInfoList(Collection<String> ids) {
        return settleInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<SettleInfoDO> getSettleInfoPage(SettleInfoPageReqVO pageReqVO) {
        return settleInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<SettleInfoDO> getSettleInfoList(SettleInfoExportReqVO exportReqVO) {
        return settleInfoMapper.selectList(exportReqVO);
    }

}
