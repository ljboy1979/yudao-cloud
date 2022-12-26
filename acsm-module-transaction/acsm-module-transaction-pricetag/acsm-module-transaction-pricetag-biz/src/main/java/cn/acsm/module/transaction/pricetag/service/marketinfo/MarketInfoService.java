package cn.acsm.module.transaction.pricetag.service.marketinfo;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.pricetag.controller.admin.marketinfo.vo.*;
import cn.acsm.module.transaction.pricetag.dal.dataobject.marketinfo.MarketInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 市场信息 Service 接口
 *
 * @author 芋道源码
 */
public interface MarketInfoService {

    /**
     * 创建市场信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createMarketInfo(@Valid MarketInfoCreateReqVO createReqVO);

    /**
     * 更新市场信息
     *
     * @param updateReqVO 更新信息
     */
    void updateMarketInfo(@Valid MarketInfoUpdateReqVO updateReqVO);

    /**
     * 删除市场信息
     *
     * @param id 编号
     */
    void deleteMarketInfo(String id);

    /**
     * 获得市场信息
     *
     * @param id 编号
     * @return 市场信息
     */
    MarketInfoDO getMarketInfo(String id);

    /**
     * 获得市场信息列表
     *
     * @param ids 编号
     * @return 市场信息列表
     */
    List<MarketInfoDO> getMarketInfoList(Collection<String> ids);

    /**
     * 获得市场信息分页
     *
     * @param pageReqVO 分页查询
     * @return 市场信息分页
     */
    PageResult<MarketInfoDO> getMarketInfoPage(MarketInfoPageReqVO pageReqVO);

    /**
     * 获得市场信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 市场信息列表
     */
    List<MarketInfoDO> getMarketInfoList(MarketInfoExportReqVO exportReqVO);

    List<MarketInfoDO> getList();
}
