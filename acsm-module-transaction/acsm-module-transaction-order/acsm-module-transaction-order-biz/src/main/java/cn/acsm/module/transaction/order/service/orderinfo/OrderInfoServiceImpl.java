package cn.acsm.module.transaction.order.service.orderinfo;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.transaction.order.controller.admin.orderinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.orderinfo.OrderInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.transaction.order.convert.orderinfo.OrderInfoConvert;
import cn.acsm.module.transaction.order.dal.mysql.orderinfo.OrderInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.transaction.order.enums.ErrorCodeConstants.*;

/**
 * 订单 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class OrderInfoServiceImpl implements OrderInfoService {

    @Resource
    private OrderInfoMapper infoMapper;

    @Override
    public String createInfo(OrderInfoCreateReqVO createReqVO) {
        // 插入
        OrderInfoDO info = OrderInfoConvert.INSTANCE.convert(createReqVO);
        infoMapper.insert(info);
        // 返回
        return info.getId();
    }

    @Override
    public void updateInfo(OrderInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateInfoExists(updateReqVO.getId());
        // 更新
        OrderInfoDO updateObj = OrderInfoConvert.INSTANCE.convert(updateReqVO);
        infoMapper.updateById(updateObj);
    }

    @Override
    public void deleteInfo(String id) {
        // 校验存在
        this.validateInfoExists(id);
        // 删除
        infoMapper.deleteById(id);
    }

    private void validateInfoExists(String id) {
        if (infoMapper.selectById(id) == null) {
            throw exception(INFO_NOT_EXISTS);
        }
    }

    @Override
    public OrderInfoDO getInfo(String id) {
        return infoMapper.selectById(id);
    }

    @Override
    public List<OrderInfoDO> getInfoList(Collection<String> ids) {
        return infoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<OrderInfoDO> getInfoPage(OrderInfoPageReqVO pageReqVO) {
        return infoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<OrderInfoDO> getInfoList(OrderInfoExportReqVO exportReqVO) {
        return infoMapper.selectList(exportReqVO);
    }

}
