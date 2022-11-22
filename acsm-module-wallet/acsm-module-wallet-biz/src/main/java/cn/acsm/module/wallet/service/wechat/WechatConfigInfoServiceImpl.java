package cn.acsm.module.wallet.service.wechat;

import cn.acsm.module.wallet.controller.admin.wechat.vo.WechatConfigInfoCreateReqVO;
import cn.acsm.module.wallet.controller.admin.wechat.vo.WechatConfigInfoExportReqVO;
import cn.acsm.module.wallet.controller.admin.wechat.vo.WechatConfigInfoPageReqVO;
import cn.acsm.module.wallet.controller.admin.wechat.vo.WechatConfigInfoUpdateReqVO;
import cn.acsm.module.wallet.convert.wechat.WechatConfigInfoConvert;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.wallet.dal.dataobject.wechat.WechatConfigInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.wallet.dal.mysql.wechat.WechatConfigInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.wallet.enums.ErrorCodeConstants.*;

/**
 * 微信支付配置信息 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class WechatConfigInfoServiceImpl implements WechatConfigInfoService {

    @Resource
    private WechatConfigInfoMapper wechatConfigInfoMapper;

    @Override
    public Long createWechatConfigInfo(WechatConfigInfoCreateReqVO createReqVO) {
        // 插入
        WechatConfigInfoDO wechatConfigInfo = WechatConfigInfoConvert.INSTANCE.convert(createReqVO);
        wechatConfigInfoMapper.insert(wechatConfigInfo);
        // 返回
        return wechatConfigInfo.getId();
    }

    @Override
    public void updateWechatConfigInfo(WechatConfigInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateWechatConfigInfoExists(updateReqVO.getId());
        // 更新
        WechatConfigInfoDO updateObj = WechatConfigInfoConvert.INSTANCE.convert(updateReqVO);
        wechatConfigInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteWechatConfigInfo(Long id) {
        // 校验存在
        this.validateWechatConfigInfoExists(id);
        // 删除
        wechatConfigInfoMapper.deleteById(id);
    }

    private void validateWechatConfigInfoExists(Long id) {
        if (wechatConfigInfoMapper.selectById(id) == null) {
            throw exception(WECHAT_CONFIG_INFO_NOT_EXISTS);
        }
    }

    @Override
    public WechatConfigInfoDO getWechatConfigInfo(Long id) {
        return wechatConfigInfoMapper.selectById(id);
    }

    @Override
    public List<WechatConfigInfoDO> getWechatConfigInfoList(Collection<Long> ids) {
        return wechatConfigInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<WechatConfigInfoDO> getWechatConfigInfoPage(WechatConfigInfoPageReqVO pageReqVO) {
        return wechatConfigInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<WechatConfigInfoDO> getWechatConfigInfoList(WechatConfigInfoExportReqVO exportReqVO) {
        return wechatConfigInfoMapper.selectList(exportReqVO);
    }

}
