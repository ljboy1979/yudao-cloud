package cn.acsm.module.user.user.service.wechat;

import cn.acsm.module.user.user.controller.admin.wechat.vo.WeixinLoginInfoCreateReqVO;
import cn.acsm.module.user.user.controller.admin.wechat.vo.WeixinLoginInfoExportReqVO;
import cn.acsm.module.user.user.controller.admin.wechat.vo.WeixinLoginInfoPageReqVO;
import cn.acsm.module.user.user.controller.admin.wechat.vo.WeixinLoginInfoUpdateReqVO;
import cn.acsm.module.user.user.convert.wechat.WeixinLoginInfoConvert;
import cn.acsm.module.user.user.dal.dataobject.wechat.WeixinLoginInfoDO;
import cn.acsm.module.user.user.dal.mysql.wechat.WeixinLoginInfoMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.user.user.enums.ErrorCodeConstants.WEIXIN_LOGIN_INFO_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 微信登录信息记录 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class WeixinLoginInfoServiceImpl implements WeixinLoginInfoService {

    @Resource
    private WeixinLoginInfoMapper weixinLoginInfoMapper;

    @Override
    public Long createWeixinLoginInfo(WeixinLoginInfoCreateReqVO createReqVO) {
        // 插入
        WeixinLoginInfoDO weixinLoginInfo = WeixinLoginInfoConvert.INSTANCE.convert(createReqVO);
        weixinLoginInfoMapper.insert(weixinLoginInfo);
        // 返回
        return weixinLoginInfo.getId();
    }

    @Override
    public void updateWeixinLoginInfo(WeixinLoginInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateWeixinLoginInfoExists(updateReqVO.getId());
        // 更新
        WeixinLoginInfoDO updateObj = WeixinLoginInfoConvert.INSTANCE.convert(updateReqVO);
        weixinLoginInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteWeixinLoginInfo(Long id) {
        // 校验存在
        this.validateWeixinLoginInfoExists(id);
        // 删除
        weixinLoginInfoMapper.deleteById(id);
    }

    private void validateWeixinLoginInfoExists(Long id) {
        if (weixinLoginInfoMapper.selectById(id) == null) {
            throw exception(WEIXIN_LOGIN_INFO_NOT_EXISTS);
        }
    }

    @Override
    public WeixinLoginInfoDO getWeixinLoginInfo(Long id) {
        return weixinLoginInfoMapper.selectById(id);
    }

    @Override
    public List<WeixinLoginInfoDO> getWeixinLoginInfoList(Collection<Long> ids) {
        return weixinLoginInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<WeixinLoginInfoDO> getWeixinLoginInfoPage(WeixinLoginInfoPageReqVO pageReqVO) {
        return weixinLoginInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<WeixinLoginInfoDO> getWeixinLoginInfoList(WeixinLoginInfoExportReqVO exportReqVO) {
        return weixinLoginInfoMapper.selectList(exportReqVO);
    }

}
