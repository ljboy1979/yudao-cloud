package cn.acsm.module.purchase.service.purchase;

import cn.acsm.module.purchase.controller.admin.purchase.vo.PurchaseCreateReqVO;
import cn.acsm.module.purchase.controller.admin.purchase.vo.PurchaseExportReqVO;
import cn.acsm.module.purchase.controller.admin.purchase.vo.PurchasePageReqVO;
import cn.acsm.module.purchase.controller.admin.purchase.vo.PurchaseUpdateReqVO;
import cn.acsm.module.purchase.convert.purchase.PurchaseConvert;
import cn.acsm.module.purchase.dal.dataobject.purchase.PurchaseDO;
import cn.acsm.module.purchase.dal.mysql.purchase.PurchaseMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.purchase.enums.ErrorCodeConstants.PURCHASE_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 采购单 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
@Transactional(readOnly = false)
public class PurchaseServiceImpl implements PurchaseService {

    @Resource
    private PurchaseMapper purchaseMapper;

    @Override
    public Long createpurchase(PurchaseCreateReqVO createReqVO) {
        // 插入
        PurchaseDO purchase = PurchaseConvert.INSTANCE.convert(createReqVO);
        purchaseMapper.insert(purchase);
        // 返回
        return purchase.getId();
    }

    @Override
    public void updatepurchase(PurchaseUpdateReqVO updateReqVO) {
        // 校验存在
        this.validatepurchaseExists(updateReqVO.getId());
        // 更新
        PurchaseDO updateObj = PurchaseConvert.INSTANCE.convert(updateReqVO);
        purchaseMapper.updateById(updateObj);
    }

    @Override
    public void deletepurchase(Long id) {
        // 校验存在
        this.validatepurchaseExists(id);
        // 删除
        purchaseMapper.deleteById(id);
    }

    private void validatepurchaseExists(Long id) {
        if (purchaseMapper.selectById(id) == null) {
            throw exception(PURCHASE_NOT_EXISTS);
        }
    }

    @Override
    public PurchaseDO getpurchase(Long id) {
        return purchaseMapper.selectById(id);
    }

    @Override
    public List<PurchaseDO> getpurchaseList(Collection<Long> ids) {
        return purchaseMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PurchaseDO> getpurchasePage(PurchasePageReqVO pageReqVO) {
        return purchaseMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PurchaseDO> getpurchaseList(PurchaseExportReqVO exportReqVO) {
        return purchaseMapper.selectList(exportReqVO);
    }

}
