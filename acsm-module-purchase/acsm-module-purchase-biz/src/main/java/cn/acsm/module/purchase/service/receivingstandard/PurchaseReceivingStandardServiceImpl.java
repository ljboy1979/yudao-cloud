package cn.acsm.module.purchase.service.receivingstandard;

import cn.acsm.module.purchase.controller.admin.receivingstandard.vo.PurchaseReceivingStandardCreateReqVO;
import cn.acsm.module.purchase.controller.admin.receivingstandard.vo.PurchaseReceivingStandardExportReqVO;
import cn.acsm.module.purchase.controller.admin.receivingstandard.vo.PurchaseReceivingStandardPageReqVO;
import cn.acsm.module.purchase.controller.admin.receivingstandard.vo.PurchaseReceivingStandardUpdateReqVO;
import cn.acsm.module.purchase.convert.receivingstandard.PurchaseReceivingStandardConvert;
import cn.acsm.module.purchase.dal.dataobject.receivingstandard.PurchaseReceivingStandardDO;
import cn.acsm.module.purchase.dal.mysql.receivingstandard.PurchaseReceivingStandardMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.purchase.enums.ErrorCodeConstants.RECEIVING_STANDARD_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 收货标准 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PurchaseReceivingStandardServiceImpl implements PurchaseReceivingStandardService {

    @Resource
    private PurchaseReceivingStandardMapper receivingStandardMapper;

    @Override
    public Long createReceivingStandard(PurchaseReceivingStandardCreateReqVO createReqVO) {
        // 插入
        PurchaseReceivingStandardDO receivingStandard = PurchaseReceivingStandardConvert.INSTANCE.convert(createReqVO);
        receivingStandardMapper.insert(receivingStandard);
        // 返回
        return receivingStandard.getId();
    }

    @Override
    public void updateReceivingStandard(PurchaseReceivingStandardUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateReceivingStandardExists(updateReqVO.getId());
        // 更新
        PurchaseReceivingStandardDO updateObj = PurchaseReceivingStandardConvert.INSTANCE.convert(updateReqVO);
        receivingStandardMapper.updateById(updateObj);
    }

    @Override
    public void deleteReceivingStandard(Long id) {
        // 校验存在
        this.validateReceivingStandardExists(id);
        // 删除
        receivingStandardMapper.deleteById(id);
    }

    private void validateReceivingStandardExists(Long id) {
        if (receivingStandardMapper.selectById(id) == null) {
            throw exception(RECEIVING_STANDARD_NOT_EXISTS);
        }
    }

    @Override
    public PurchaseReceivingStandardDO getReceivingStandard(Long id) {
        return receivingStandardMapper.selectById(id);
    }

    @Override
    public List<PurchaseReceivingStandardDO> getReceivingStandardList(Collection<Long> ids) {
        return receivingStandardMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PurchaseReceivingStandardDO> getReceivingStandardPage(PurchaseReceivingStandardPageReqVO pageReqVO) {
        return receivingStandardMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PurchaseReceivingStandardDO> getReceivingStandardList(PurchaseReceivingStandardExportReqVO exportReqVO) {
        return receivingStandardMapper.selectList(exportReqVO);
    }

}
