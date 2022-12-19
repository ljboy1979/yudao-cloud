package cn.acsm.module.production.tunnel.service.costbook;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.production.tunnel.controller.admin.costbook.vo.*;
import cn.acsm.module.production.tunnel.dal.dataobject.costbook.CostBookDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 地块账本 Service 接口
 *
 * @author 芋道源码
 */
public interface CostBookService {

    /**
     * 创建地块账本
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createCostBook(@Valid CostBookCreateReqVO createReqVO);

    /**
     * 更新地块账本
     *
     * @param updateReqVO 更新信息
     */
    void updateCostBook(@Valid CostBookUpdateReqVO updateReqVO);

    /**
     * 删除地块账本
     *
     * @param id 编号
     */
    void deleteCostBook(Long id);

    /**
     * 获得地块账本
     *
     * @param id 编号
     * @return 地块账本
     */
    CostBookDO getCostBook(Long id);

    /**
     * 获得地块账本列表
     *
     * @param ids 编号
     * @return 地块账本列表
     */
    List<CostBookDO> getCostBookList(Collection<Long> ids);

    /**
     * 获得地块账本分页
     *
     * @param pageReqVO 分页查询
     * @return 地块账本分页
     */
    PageResult<CostBookDO> getCostBookPage(CostBookPageReqVO pageReqVO);

    /**
     * 获得地块账本列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 地块账本列表
     */
    List<CostBookDO> getCostBookList(CostBookExportReqVO exportReqVO);

}
