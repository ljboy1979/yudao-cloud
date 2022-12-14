package cn.acsm.module.purchase.service.purchase;

import cn.acsm.module.purchase.controller.admin.purchase.vo.PurchaseCreateReqVO;
import cn.acsm.module.purchase.controller.admin.purchase.vo.PurchaseExportReqVO;
import cn.acsm.module.purchase.controller.admin.purchase.vo.PurchasePageReqVO;
import cn.acsm.module.purchase.controller.admin.purchase.vo.PurchaseUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.purchase.PurchaseDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 采购单 Service 接口
 *
 * @author 芋道源码
 */
public interface PurchaseService {

    /**
     * 创建采购单
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createpurchase(@Valid PurchaseCreateReqVO createReqVO);

    /**
     * 更新采购单
     *
     * @param updateReqVO 更新信息
     */
    void updatepurchase(@Valid PurchaseUpdateReqVO updateReqVO);

    /**
     * 删除采购单
     *
     * @param id 编号
     */
    void deletepurchase(Long id);

    /**
     * 获得采购单
     *
     * @param id 编号
     * @return 采购单
     */
    PurchaseDO getpurchase(Long id);

    /**
     * 获得采购单列表
     *
     * @param ids 编号
     * @return 采购单列表
     */
    List<PurchaseDO> getpurchaseList(Collection<Long> ids);

    /**
     * 获得采购单分页
     *
     * @param pageReqVO 分页查询
     * @return 采购单分页
     */
    PageResult<PurchaseDO> getpurchasePage(PurchasePageReqVO pageReqVO);

    /**
     * 获得采购单列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 采购单列表
     */
    List<PurchaseDO> getpurchaseList(PurchaseExportReqVO exportReqVO);

}
