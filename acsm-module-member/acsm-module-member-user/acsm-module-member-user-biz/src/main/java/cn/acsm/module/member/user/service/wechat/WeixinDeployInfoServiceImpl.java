package cn.acsm.module.member.user.service.wechat;

import cn.acsm.module.member.user.controller.admin.wechat.vo.WeixinDeployInfoCreateReqVO;
import cn.acsm.module.member.user.controller.admin.wechat.vo.WeixinDeployInfoExportReqVO;
import cn.acsm.module.member.user.controller.admin.wechat.vo.WeixinDeployInfoPageReqVO;
import cn.acsm.module.member.user.controller.admin.wechat.vo.WeixinDeployInfoUpdateReqVO;
import cn.acsm.module.member.user.convert.wechat.WeixinDeployInfoConvert;
import cn.acsm.module.member.user.dal.dataobject.wechat.WeixinDeployInfoDO;
import cn.acsm.module.member.user.dal.mysql.wechat.WeixinDeployInfoMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.member.user.enums.ErrorCodeConstants.WEIXIN_DEPLOY_INFO_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 微信公众号配置信息 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class WeixinDeployInfoServiceImpl implements WeixinDeployInfoService {

    @Resource
    private WeixinDeployInfoMapper weixinDeployInfoMapper;

    @Override
    public Long createWeixinDeployInfo(WeixinDeployInfoCreateReqVO createReqVO) {
        // 插入
        WeixinDeployInfoDO weixinDeployInfo = WeixinDeployInfoConvert.INSTANCE.convert(createReqVO);
        weixinDeployInfoMapper.insert(weixinDeployInfo);
        // 返回
        return weixinDeployInfo.getId();
    }

    @Override
    public void updateWeixinDeployInfo(WeixinDeployInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateWeixinDeployInfoExists(updateReqVO.getId());
        // 更新
        WeixinDeployInfoDO updateObj = WeixinDeployInfoConvert.INSTANCE.convert(updateReqVO);
        weixinDeployInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteWeixinDeployInfo(Long id) {
        // 校验存在
        this.validateWeixinDeployInfoExists(id);
        // 删除
        weixinDeployInfoMapper.deleteById(id);
    }

    private void validateWeixinDeployInfoExists(Long id) {
        if (weixinDeployInfoMapper.selectById(id) == null) {
            throw exception(WEIXIN_DEPLOY_INFO_NOT_EXISTS);
        }
    }

    @Override
    public WeixinDeployInfoDO getWeixinDeployInfo(Long id) {
        return weixinDeployInfoMapper.selectById(id);
    }

    @Override
    public List<WeixinDeployInfoDO> getWeixinDeployInfoList(Collection<Long> ids) {
        return weixinDeployInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<WeixinDeployInfoDO> getWeixinDeployInfoPage(WeixinDeployInfoPageReqVO pageReqVO) {
        return weixinDeployInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<WeixinDeployInfoDO> getWeixinDeployInfoList(WeixinDeployInfoExportReqVO exportReqVO) {
        return weixinDeployInfoMapper.selectList(exportReqVO);
    }

    @Override
    public List<WeixinDeployInfoDO> selectListByTenantId(WeixinDeployInfoDO weixinDeployInfoDO) {
        return weixinDeployInfoMapper.selectListByTenantId(weixinDeployInfoDO);
    }

}
