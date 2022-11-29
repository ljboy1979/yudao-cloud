package cn.acsm.module.transaction.sales.service.commoditysku;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.transaction.sales.controller.admin.commoditysku.vo.CommoditySkuCreateReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commoditysku.vo.CommoditySkuExportReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commoditysku.vo.CommoditySkuPageReqVO;
import cn.acsm.module.transaction.sales.controller.admin.commoditysku.vo.CommoditySkuUpdateReqVO;
import cn.acsm.module.transaction.sales.dal.dataobject.commoditysku.CommoditySkuDO;
import cn.acsm.module.transaction.sales.controller.admin.commoditysku.vo.*;
import cn.acsm.module.transaction.sales.dal.dataobject.commoditysku.CommoditySkuDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 商品sku Service 接口
 *
 * @author 芋道源码
 */
public interface CommoditySkuService {

    /**
     * 创建商品sku
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createCommoditySku(@Valid CommoditySkuCreateReqVO createReqVO);

    /**
     * 更新商品sku
     *
     * @param updateReqVO 更新信息
     */
    void updateCommoditySku(@Valid CommoditySkuUpdateReqVO updateReqVO);

    /**
     * 删除商品sku
     *
     * @param id 编号
     */
    void deleteCommoditySku(String id);

    /**
     * 获得商品sku
     *
     * @param id 编号
     * @return 商品sku
     */
    CommoditySkuDO getCommoditySku(String id);

    /**
     * 获得商品sku列表
     *
     * @param ids 编号
     * @return 商品sku列表
     */
    List<CommoditySkuDO> getCommoditySkuList(Collection<String> ids);

    /**
     * 获得商品sku分页
     *
     * @param pageReqVO 分页查询
     * @return 商品sku分页
     */
    PageResult<CommoditySkuDO> getCommoditySkuPage(CommoditySkuPageReqVO pageReqVO);

    /**
     * 获得商品sku列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 商品sku列表
     */
    List<CommoditySkuDO> getCommoditySkuList(CommoditySkuExportReqVO exportReqVO);

}
