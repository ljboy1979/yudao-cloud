package cn.acsm.module.purchase.service.details;

import cn.acsm.module.purchase.controller.admin.details.vo.PurchaseDetailsCreateReqVO;
import cn.acsm.module.purchase.controller.admin.details.vo.PurchaseDetailsExportReqVO;
import cn.acsm.module.purchase.controller.admin.details.vo.PurchaseDetailsPageReqVO;
import cn.acsm.module.purchase.controller.admin.details.vo.PurchaseDetailsUpdateReqVO;
import cn.acsm.module.purchase.convert.details.PurchaseDetailsConvert;
import cn.acsm.module.purchase.dal.dataobject.details.PurchaseDetailsDO;
import cn.acsm.module.purchase.dal.mysql.details.PurchaseDetailsMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.purchase.enums.ErrorCodeConstants.DETAILS_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 采购单明细 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PurchaseDetailsServiceImpl implements PurchaseDetailsService {

    @Resource
    private PurchaseDetailsMapper detailsMapper;

    @Override
    public Long createDetails(PurchaseDetailsCreateReqVO createReqVO) {
        // 插入
        PurchaseDetailsDO details = PurchaseDetailsConvert.INSTANCE.convert(createReqVO);
        detailsMapper.insert(details);
        // 返回
        return details.getId();
    }

    @Override
    public void updateDetails(PurchaseDetailsUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateDetailsExists(updateReqVO.getId());
        // 更新
        PurchaseDetailsDO updateObj = PurchaseDetailsConvert.INSTANCE.convert(updateReqVO);
        detailsMapper.updateById(updateObj);
    }

    @Override
    public void deleteDetails(Long id) {
        // 校验存在
        this.validateDetailsExists(id);
        // 删除
        detailsMapper.deleteById(id);
    }

    private void validateDetailsExists(Long id) {
        if (detailsMapper.selectById(id) == null) {
            throw exception(DETAILS_NOT_EXISTS);
        }
    }

    @Override
    public PurchaseDetailsDO getDetails(Long id) {
        return detailsMapper.selectById(id);
    }

    @Override
    public List<PurchaseDetailsDO> getDetailsList(Collection<Long> ids) {
        return detailsMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PurchaseDetailsDO> getDetailsPage(PurchaseDetailsPageReqVO pageReqVO) {
        return detailsMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PurchaseDetailsDO> getDetailsList(PurchaseDetailsExportReqVO exportReqVO) {
        return detailsMapper.selectList(exportReqVO);
    }

}
