package cn.iocoder.yudao.module.transaction.sales.service.commodityorganization;

import java.util.*;
import javax.validation.*;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.commodityorganization.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.commodityorganization.CommodityOrganizationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 商品组成 Service 接口
 *
 * @author 芋道源码
 */
public interface CommodityOrganizationService {

    /**
     * 创建商品组成
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    CommonResult<String> createCommodityOrganization(@Valid CommodityOrganizationCreateReqVO createReqVO);

    /**
     * 更新商品组成
     *
     * @param updateReqVO 更新信息
     */
    void updateCommodityOrganization(@Valid CommodityOrganizationUpdateReqVO updateReqVO);

    /**
     * 删除商品组成
     *
     * @param id 编号
     */
    void deleteCommodityOrganization(String id);

    /**
     * 获得商品组成
     *
     * @param id 编号
     * @return 商品组成
     */
    CommodityOrganizationDO getCommodityOrganization(String id);

    /**
     * 获得商品组成列表
     *
     * @param ids 编号
     * @return 商品组成列表
     */
    List<CommodityOrganizationDO> getCommodityOrganizationList(Collection<String> ids);

    /**
     * 获得商品组成分页
     *
     * @param pageReqVO 分页查询
     * @return 商品组成分页
     */
    PageResult<CommodityOrganizationDO> getCommodityOrganizationPage(CommodityOrganizationPageReqVO pageReqVO);

    /**
     * 获得商品组成列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 商品组成列表
     */
    List<CommodityOrganizationDO> getCommodityOrganizationList(CommodityOrganizationExportReqVO exportReqVO);

}
