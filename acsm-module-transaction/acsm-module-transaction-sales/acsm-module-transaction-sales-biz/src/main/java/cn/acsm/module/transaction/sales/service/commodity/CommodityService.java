package cn.acsm.module.transaction.sales.service.commodity;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.transaction.sales.dal.dataobject.commodity.CommodityDO;
import cn.acsm.module.transaction.sales.controller.admin.commodity.vo.*;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 商品 Service 接口
 *
 * @author 芋道源码
 */
public interface CommodityService {

    /**
     * 创建商品
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    CommonResult<String> createCommodity(@Valid CommodityCreateReqVO createReqVO);

    /**
     * 更新商品
     *
     * @param updateReqVO 更新信息
     */
    CommonResult<String>  updateCommodity(@Valid CommodityUpdateReqVO updateReqVO);

    /**
     * 删除商品
     *
     * @param id 编号
     */
    void deleteCommodity(String id);

    /**
     * 获得商品
     *
     * @param id 编号
     * @return 商品
     */
    CommodityDO getCommodity(String id);

    /**
     * 获得商品列表
     *
     * @param ids 编号
     * @return 商品列表
     */
    List<CommodityDO> getCommodityList(Collection<String> ids);

    /**
     * 获得商品分页
     *
     * @param pageReqVO 分页查询
     * @return 商品分页
     */
    PageResult<CommodityDO> getCommodityPage(CommodityPageReqVO pageReqVO);

    /**
     * 获得商品列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 商品列表
     */
    List<CommodityDO> getCommodityList(CommodityExportReqVO exportReqVO);

}
