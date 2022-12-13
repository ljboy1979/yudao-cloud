package cn.acsm.module.transaction.order.service.giftinfo;

import cn.acsm.module.transaction.order.util.ConfigNumberUtil;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.order.controller.admin.giftinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.giftinfo.GiftInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.order.convert.giftinfo.GiftInfoConvert;
import cn.acsm.module.transaction.order.dal.mysql.giftinfo.GiftInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.order.enums.ErrorCodeConstants.*;

/**
 * 赠品 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GiftInfoServiceImpl implements GiftInfoService {

    @Resource
    private GiftInfoMapper giftInfoMapper;
    @Resource
    private ConfigNumberUtil configNumberUtil;

    @Override
    public Integer createGiftInfo(GiftInfoCreateReqVO createReqVO) {
        Long tenantId = SecurityFrameworkUtils.getLoginUser().getTenantId();
        String number = configNumberUtil.getNumber("order_gift_info"+tenantId);
        // 插入
        GiftInfoDO giftInfo = GiftInfoConvert.INSTANCE.convert(createReqVO);
        giftInfo.setGiftNumber("ZP"+number);
        giftInfoMapper.insert(giftInfo);
        // 返回
        return giftInfo.getId();
    }

    @Override
    public void updateGiftInfo(GiftInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateGiftInfoExists(updateReqVO.getId());
        // 更新
        GiftInfoDO updateObj = GiftInfoConvert.INSTANCE.convert(updateReqVO);
        giftInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteGiftInfo(Integer id) {
        // 校验存在
        this.validateGiftInfoExists(id);
        // 删除
        giftInfoMapper.deleteById(id);
    }

    private void validateGiftInfoExists(Integer id) {
        if (giftInfoMapper.selectById(id) == null) {
            throw exception(GIFT_INFO_NOT_EXISTS);
        }
    }

    @Override
    public GiftInfoDO getGiftInfo(Integer id) {
        return giftInfoMapper.selectById(id);
    }

    @Override
    public List<GiftInfoDO> getGiftInfoList(Collection<Integer> ids) {
        return giftInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<GiftInfoDO> getGiftInfoPage(GiftInfoPageReqVO pageReqVO) {
        return giftInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GiftInfoDO> getGiftInfoList(GiftInfoExportReqVO exportReqVO) {
        return giftInfoMapper.selectList(exportReqVO);
    }

}
