package cn.acsm.module.transaction.order.service.sartinfo;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.order.controller.admin.sartinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.sartinfo.SartInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.order.convert.sartinfo.SartInfoConvert;
import cn.acsm.module.transaction.order.dal.mysql.sartinfo.SartInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.order.enums.ErrorCodeConstants.*;

/**
 * 购物车 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class SartInfoServiceImpl implements SartInfoService {

    @Resource
    private SartInfoMapper sartInfoMapper;

    @Override
    public String createSartInfo(SartInfoCreateReqVO createReqVO) {
        // 插入
        SartInfoDO sartInfo = SartInfoConvert.INSTANCE.convert(createReqVO);
        sartInfoMapper.insert(sartInfo);
        // 返回
        return sartInfo.getId();
    }

    @Override
    public void updateSartInfo(SartInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateSartInfoExists(updateReqVO.getId());
        // 更新
        SartInfoDO updateObj = SartInfoConvert.INSTANCE.convert(updateReqVO);
        sartInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteSartInfo(String id) {
        // 校验存在
        this.validateSartInfoExists(id);
        // 删除
        sartInfoMapper.deleteById(id);
    }

    private void validateSartInfoExists(String id) {
        if (sartInfoMapper.selectById(id) == null) {
            throw exception(SART_INFO_NOT_EXISTS);
        }
    }

    @Override
    public SartInfoDO getSartInfo(String id) {
        return sartInfoMapper.selectById(id);
    }

    @Override
    public List<SartInfoDO> getSartInfoList(Collection<String> ids) {
        return sartInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<SartInfoDO> getSartInfoPage(SartInfoPageReqVO pageReqVO) {
        return sartInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<SartInfoDO> getSartInfoList(SartInfoExportReqVO exportReqVO) {
        return sartInfoMapper.selectList(exportReqVO);
    }

}
