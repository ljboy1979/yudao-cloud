package cn.acsm.module.stock.service.inventory;

import cn.acsm.module.stock.api.inventory.qo.InventoryQO;
import cn.acsm.module.stock.api.inventory.qo.InventoryVirtualQO;
import cn.acsm.module.stock.api.inventory.vo.StockInventoryApiReqVO;
import cn.acsm.module.stock.controller.admin.inventory.vo.*;
import cn.acsm.module.stock.dal.dataobject.inventory.StockInventoryDO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 库存清单 Service 接口
 *
 * @author 芋道源码
 */
public interface StockInventoryService {

    /**
     * 创建库存清单
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createInventory(@Valid StockInventoryCreateReqVO createReqVO);

    /**
     * 更新库存清单
     *
     * @param updateReqVO 更新信息
     */
    void updateInventory(@Valid StockInventoryUpdateReqVO updateReqVO);

    /**
     * 删除库存清单
     *
     * @param id 编号
     */
    void deleteInventory(String id);

    /**
     * 获得库存清单
     *
     * @param id 编号
     * @return 库存清单
     */
    StockInventoryDO getInventory(String id);

    /**
     * 获得库存清单列表
     *
     * @param ids 编号
     * @return 库存清单列表
     */
    List<StockInventoryDO> getInventoryList(Collection<String> ids);

    /**
     * 获得库存清单分页
     *
     * @param pageReqVO 分页查询
     * @return 库存清单分页
     */
    Page<StockInventoryDO> getInventoryPage(StockInventoryPageReqVO pageReqVO);

    /**
     * 获得库存清单列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 库存清单列表
     */
    List<StockInventoryDO> getInventoryList(StockInventoryExportReqVO exportReqVO);

    /**
     * 3.7.2.6.更新库存量
     *
     * @param updateReqVO 更新信息
     */
    void updateInventoryCount(@Valid StockInventoryUpdateCountVO updateReqVO);

    /**
     * 3.7.2.8.报损
     * @param reportingVO 更新信息
     */
    void lossReporting(@Valid StockLossReportingVO reportingVO);

//    --------------- 远程调用接口 ---------------
    /**
     * 根据条件获得库存清单列表
     * @param apiReqVO 查询条件
     * @return 库存清单列表
     */
    StockInventoryApiReqVO getInventory(InventoryQO apiReqVO);

    /**
     * 获取库存清单数据
     *
     * @param packagingSpecificationId
     * @return 编号
     */
    StockInventoryApiReqVO getInventorysBySpId(String packagingSpecificationId);

    /**
     * 根据规格id修改虚拟库存量
     *
     * @param qo
     */
    Boolean updateInventorys(InventoryVirtualQO qo);
}
