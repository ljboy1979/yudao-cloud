package cn.acsm.module.transaction.order.service.reserveinfo;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.order.controller.admin.reserveinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.reserveinfo.ReserveInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.order.convert.reserveinfo.ReserveInfoConvert;
import cn.acsm.module.transaction.order.dal.mysql.reserveinfo.ReserveInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.order.enums.ErrorCodeConstants.*;

/**
 * 预定订单 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ReserveInfoServiceImpl implements ReserveInfoService {

    @Resource
    private ReserveInfoMapper reserveInfoMapper;

    @Override
    public String createReserveInfo(ReserveInfoCreateReqVO createReqVO) {
        // 插入
        ReserveInfoDO reserveInfo = ReserveInfoConvert.INSTANCE.convert(createReqVO);
        reserveInfoMapper.insert(reserveInfo);
        // 返回
        return reserveInfo.getId();
    }

    @Override
    public void updateReserveInfo(ReserveInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateReserveInfoExists(updateReqVO.getId());
        // 更新
        ReserveInfoDO updateObj = ReserveInfoConvert.INSTANCE.convert(updateReqVO);
        reserveInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteReserveInfo(String id) {
        // 校验存在
        this.validateReserveInfoExists(id);
        // 删除
        reserveInfoMapper.deleteById(id);
    }

    private void validateReserveInfoExists(String id) {
        if (reserveInfoMapper.selectById(id) == null) {
            throw exception(RESERVE_INFO_NOT_EXISTS);
        }
    }

    @Override
    public ReserveInfoDO getReserveInfo(String id) {
        return reserveInfoMapper.selectById(id);
    }

    @Override
    public List<ReserveInfoDO> getReserveInfoList(Collection<String> ids) {
        return reserveInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ReserveInfoDO> getReserveInfoPage(ReserveInfoPageReqVO pageReqVO) {
        return reserveInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ReserveInfoDO> getReserveInfoList(ReserveInfoExportReqVO exportReqVO) {
        return reserveInfoMapper.selectList(exportReqVO);
    }

}
