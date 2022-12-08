package cn.acsm.module.transaction.order.service.reservedetails;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.order.controller.admin.reservedetails.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.reservedetails.ReserveDetailsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.order.convert.reservedetails.ReserveDetailsConvert;
import cn.acsm.module.transaction.order.dal.mysql.reservedetails.ReserveDetailsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.order.enums.ErrorCodeConstants.*;

/**
 * 订单预定详情 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ReserveDetailsServiceImpl implements ReserveDetailsService {

    @Resource
    private ReserveDetailsMapper reserveDetailsMapper;

    @Override
    public String createReserveDetails(ReserveDetailsCreateReqVO createReqVO) {
        // 插入
        ReserveDetailsDO reserveDetails = ReserveDetailsConvert.INSTANCE.convert(createReqVO);
        reserveDetailsMapper.insert(reserveDetails);
        // 返回
        return reserveDetails.getId();
    }

    @Override
    public void updateReserveDetails(ReserveDetailsUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateReserveDetailsExists(updateReqVO.getId());
        // 更新
        ReserveDetailsDO updateObj = ReserveDetailsConvert.INSTANCE.convert(updateReqVO);
        reserveDetailsMapper.updateById(updateObj);
    }

    @Override
    public void deleteReserveDetails(String id) {
        // 校验存在
        this.validateReserveDetailsExists(id);
        // 删除
        reserveDetailsMapper.deleteById(id);
    }

    private void validateReserveDetailsExists(String id) {
        if (reserveDetailsMapper.selectById(id) == null) {
            throw exception(RESERVE_DETAILS_NOT_EXISTS);
        }
    }

    @Override
    public ReserveDetailsDO getReserveDetails(String id) {
        return reserveDetailsMapper.selectById(id);
    }

    @Override
    public List<ReserveDetailsDO> getReserveDetailsList(Collection<String> ids) {
        return reserveDetailsMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ReserveDetailsDO> getReserveDetailsPage(ReserveDetailsPageReqVO pageReqVO) {
        return reserveDetailsMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ReserveDetailsDO> getReserveDetailsList(ReserveDetailsExportReqVO exportReqVO) {
        return reserveDetailsMapper.selectList(exportReqVO);
    }

}
