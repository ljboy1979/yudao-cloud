package cn.acsm.module.purchase.service.deliver;

import cn.acsm.module.purchase.controller.admin.deliver.vo.PurchaseDeliverCreateReqVO;
import cn.acsm.module.purchase.controller.admin.deliver.vo.PurchaseDeliverExportReqVO;
import cn.acsm.module.purchase.controller.admin.deliver.vo.PurchaseDeliverPageReqVO;
import cn.acsm.module.purchase.controller.admin.deliver.vo.PurchaseDeliverUpdateReqVO;
import cn.acsm.module.purchase.convert.deliver.PurchaseDeliverConvert;
import cn.acsm.module.purchase.dal.dataobject.deliver.PurchaseDeliverDO;
import cn.acsm.module.purchase.dal.mysql.deliver.PurchaseDeliverMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.List;

import static cn.acsm.module.purchase.enums.ErrorCodeConstants.DELIVER_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 采购交付 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PurchaseDeliverServiceImpl implements PurchaseDeliverService {

    @Autowired
    private PurchaseDeliverMapper deliverMapper;

    @Override
    public Long createDeliver(PurchaseDeliverCreateReqVO createReqVO) {
        // 插入
        PurchaseDeliverDO deliver = PurchaseDeliverConvert.INSTANCE.convert(createReqVO);
        deliverMapper.insert(deliver);
        // 返回
        return deliver.getId();
    }

    @Override
    public void updateDeliver(PurchaseDeliverUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateDeliverExists(updateReqVO.getId());
        // 更新
        PurchaseDeliverDO updateObj = PurchaseDeliverConvert.INSTANCE.convert(updateReqVO);
        deliverMapper.updateById(updateObj);
    }

    @Override
    public void deleteDeliver(Long id) {
        // 校验存在
        this.validateDeliverExists(id);
        // 删除
        deliverMapper.deleteById(id);
    }

    private void validateDeliverExists(Long id) {
        if (deliverMapper.selectById(id) == null) {
            throw exception(DELIVER_NOT_EXISTS);
        }
    }

    @Override
    public PurchaseDeliverDO getDeliver(Long id) {
        return deliverMapper.selectById(id);
    }

    @Override
    public List<PurchaseDeliverDO> getDeliverList(Collection<Long> ids) {
        return deliverMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PurchaseDeliverDO> getDeliverPage(PurchaseDeliverPageReqVO pageReqVO) {
        return deliverMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PurchaseDeliverDO> getDeliverList(PurchaseDeliverExportReqVO exportReqVO) {
        return deliverMapper.selectList(exportReqVO);
    }

}
