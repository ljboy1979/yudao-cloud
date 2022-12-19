package cn.acsm.module.purchase.service.loss;

import cn.acsm.module.purchase.controller.admin.loss.vo.PurchaseLossCreateReqVO;
import cn.acsm.module.purchase.controller.admin.loss.vo.PurchaseLossExportReqVO;
import cn.acsm.module.purchase.controller.admin.loss.vo.PurchaseLossPageReqVO;
import cn.acsm.module.purchase.controller.admin.loss.vo.PurchaseLossUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.loss.PurchaseLossDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 损耗 Service 接口
 *
 * @author 芋道源码
 */
public interface PurchaseLossService {

    /**
     * 创建损耗
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createLoss(@Valid PurchaseLossCreateReqVO createReqVO);

    /**
     * 更新损耗
     *
     * @param updateReqVO 更新信息
     */
    void updateLoss(@Valid PurchaseLossUpdateReqVO updateReqVO);

    /**
     * 删除损耗
     *
     * @param id 编号
     */
    void deleteLoss(Long id);

    /**
     * 获得损耗
     *
     * @param id 编号
     * @return 损耗
     */
    PurchaseLossDO getLoss(Long id);

    /**
     * 获得损耗列表
     *
     * @param ids 编号
     * @return 损耗列表
     */
    List<PurchaseLossDO> getLossList(Collection<Long> ids);

    /**
     * 获得损耗分页
     *
     * @param pageReqVO 分页查询
     * @return 损耗分页
     */
    PageResult<PurchaseLossDO> getLossPage(PurchaseLossPageReqVO pageReqVO);

    /**
     * 获得损耗列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 损耗列表
     */
    List<PurchaseLossDO> getLossList(PurchaseLossExportReqVO exportReqVO);

}
