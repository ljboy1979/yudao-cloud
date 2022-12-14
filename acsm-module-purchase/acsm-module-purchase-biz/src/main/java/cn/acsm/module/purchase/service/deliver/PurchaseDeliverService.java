package cn.acsm.module.purchase.service.deliver;

import cn.acsm.module.purchase.controller.admin.deliver.vo.PurchaseDeliverCreateReqVO;
import cn.acsm.module.purchase.controller.admin.deliver.vo.PurchaseDeliverExportReqVO;
import cn.acsm.module.purchase.controller.admin.deliver.vo.PurchaseDeliverPageReqVO;
import cn.acsm.module.purchase.controller.admin.deliver.vo.PurchaseDeliverUpdateReqVO;
import cn.acsm.module.purchase.dal.dataobject.deliver.PurchaseDeliverDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 采购交付 Service 接口
 *
 * @author 芋道源码
 */
public interface PurchaseDeliverService {

    /**
     * 创建采购交付
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createDeliver(@Valid PurchaseDeliverCreateReqVO createReqVO);

    /**
     * 更新采购交付
     *
     * @param updateReqVO 更新信息
     */
    void updateDeliver(@Valid PurchaseDeliverUpdateReqVO updateReqVO);

    /**
     * 删除采购交付
     *
     * @param id 编号
     */
    void deleteDeliver(Long id);

    /**
     * 获得采购交付
     *
     * @param id 编号
     * @return 采购交付
     */
    PurchaseDeliverDO getDeliver(Long id);

    /**
     * 获得采购交付列表
     *
     * @param ids 编号
     * @return 采购交付列表
     */
    List<PurchaseDeliverDO> getDeliverList(Collection<Long> ids);

    /**
     * 获得采购交付分页
     *
     * @param pageReqVO 分页查询
     * @return 采购交付分页
     */
    PageResult<PurchaseDeliverDO> getDeliverPage(PurchaseDeliverPageReqVO pageReqVO);

    /**
     * 获得采购交付列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 采购交付列表
     */
    List<PurchaseDeliverDO> getDeliverList(PurchaseDeliverExportReqVO exportReqVO);

}
