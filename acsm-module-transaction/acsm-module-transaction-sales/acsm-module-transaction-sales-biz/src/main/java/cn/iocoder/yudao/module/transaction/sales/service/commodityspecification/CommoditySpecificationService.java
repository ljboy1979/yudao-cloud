package cn.iocoder.yudao.module.transaction.sales.service.commodityspecification;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.transaction.sales.controller.admin.commodityspecification.vo.*;
import cn.iocoder.yudao.module.transaction.sales.dal.dataobject.commodityspecification.CommoditySpecificationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 商品规格 Service 接口
 *
 * @author 芋道源码
 */
public interface CommoditySpecificationService {

    /**
     * 创建商品规格
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createCommoditySpecification(@Valid CommoditySpecificationCreateReqVO createReqVO);

    /**
     * 更新商品规格
     *
     * @param updateReqVO 更新信息
     */
    void updateCommoditySpecification(@Valid CommoditySpecificationUpdateReqVO updateReqVO);

    /**
     * 删除商品规格
     *
     * @param id 编号
     */
    void deleteCommoditySpecification(String id);

    /**
     * 获得商品规格
     *
     * @param id 编号
     * @return 商品规格
     */
    CommoditySpecificationDO getCommoditySpecification(String id);

    /**
     * 获得商品规格列表
     *
     * @param ids 编号
     * @return 商品规格列表
     */
    List<CommoditySpecificationDO> getCommoditySpecificationList(Collection<String> ids);

    /**
     * 获得商品规格分页
     *
     * @param pageReqVO 分页查询
     * @return 商品规格分页
     */
    PageResult<CommoditySpecificationDO> getCommoditySpecificationPage(CommoditySpecificationPageReqVO pageReqVO);

    /**
     * 获得商品规格列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 商品规格列表
     */
    List<CommoditySpecificationDO> getCommoditySpecificationList(CommoditySpecificationExportReqVO exportReqVO);

}
