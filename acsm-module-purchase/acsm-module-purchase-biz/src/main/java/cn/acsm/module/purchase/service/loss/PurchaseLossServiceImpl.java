package cn.acsm.module.purchase.service.loss;

import cn.acsm.module.purchase.api.loss.dto.LossReqDTO;
import cn.acsm.module.purchase.controller.admin.loss.vo.PurchaseLossCreateReqVO;
import cn.acsm.module.purchase.controller.admin.loss.vo.PurchaseLossExportReqVO;
import cn.acsm.module.purchase.controller.admin.loss.vo.PurchaseLossPageReqVO;
import cn.acsm.module.purchase.controller.admin.loss.vo.PurchaseLossUpdateReqVO;
import cn.acsm.module.purchase.convert.loss.PurchaseLossConvert;
import cn.acsm.module.purchase.dal.dataobject.loss.PurchaseLossDO;
import cn.acsm.module.purchase.dal.mysql.loss.PurchaseLossMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.purchase.enums.ErrorCodeConstants.LOSS_NOT_EXISTS;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 损耗 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PurchaseLossServiceImpl implements PurchaseLossService {

    @Resource
    private PurchaseLossMapper lossMapper;

    @Override
    public Long createLoss(PurchaseLossCreateReqVO createReqVO) {
        // 插入
        PurchaseLossDO loss = PurchaseLossConvert.INSTANCE.convert(createReqVO);
        lossMapper.insert(loss);
        // 返回
        return loss.getId();
    }

    @Override
    public void updateLoss(PurchaseLossUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateLossExists(updateReqVO.getId());
        // 更新
        PurchaseLossDO updateObj = PurchaseLossConvert.INSTANCE.convert(updateReqVO);
        lossMapper.updateById(updateObj);
    }

    @Override
    public void deleteLoss(Long id) {
        // 校验存在
        this.validateLossExists(id);
        // 删除
        lossMapper.deleteById(id);
    }

    private void validateLossExists(Long id) {
        if (lossMapper.selectById(id) == null) {
            throw exception(LOSS_NOT_EXISTS);
        }
    }

    @Override
    public PurchaseLossDO getLoss(Long id) {
        return lossMapper.selectById(id);
    }

    @Override
    public List<PurchaseLossDO> getLossList(Collection<Long> ids) {
        return lossMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PurchaseLossDO> getLossPage(PurchaseLossPageReqVO pageReqVO) {
        return lossMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PurchaseLossDO> getLossList(PurchaseLossExportReqVO exportReqVO) {
        return lossMapper.selectList(exportReqVO);
    }

    /**
     * 创建损耗 【stock服务调用】
     *
     * @param reqDTO 创建信息
     * @return boolean 成功 | 失败
     */
    public boolean createLoss(@Valid LossReqDTO reqDTO) {
        PurchaseLossDO lossDO = new PurchaseLossDO();
        BeanUtils.copyProperties(reqDTO, lossDO);
        return lossMapper.insert(lossDO) > 0;
    }

}
