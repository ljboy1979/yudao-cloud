package cn.acsm.module.resource.service.adoptcontentadoptprice;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.resource.controller.admin.adoptcontentadoptprice.vo.*;
import cn.acsm.module.resource.dal.dataobject.adoptcontentadoptprice.AdoptContentAdoptPriceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 认养/租凭价格 Service 接口
 *
 * @author smile
 */
public interface AdoptContentAdoptPriceService {

    /**
     * 创建认养/租凭价格
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createAdoptContentAdoptPrice(@Valid AdoptContentAdoptPriceCreateReqVO createReqVO);

    /**
     * 更新认养/租凭价格
     *
     * @param updateReqVO 更新信息
     */
    void updateAdoptContentAdoptPrice(@Valid AdoptContentAdoptPriceUpdateReqVO updateReqVO);

    /**
     * 删除认养/租凭价格
     *
     * @param id 编号
     */
    void deleteAdoptContentAdoptPrice(Long id);

    /**
     * 获得认养/租凭价格
     *
     * @param id 编号
     * @return 认养/租凭价格
     */
    AdoptContentAdoptPriceDO getAdoptContentAdoptPrice(Long id);

    /**
     * 获得认养/租凭价格列表
     *
     * @param ids 编号
     * @return 认养/租凭价格列表
     */
    List<AdoptContentAdoptPriceDO> getAdoptContentAdoptPriceList(Collection<Long> ids);

    /**
     * 获得认养/租凭价格分页
     *
     * @param pageReqVO 分页查询
     * @return 认养/租凭价格分页
     */
    PageResult<AdoptContentAdoptPriceRespVO> getAdoptContentAdoptPricePage(AdoptContentAdoptPricePageReqVO pageReqVO);

    /**
     * 获得认养/租凭价格列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 认养/租凭价格列表
     */
    List<AdoptContentAdoptPriceDO> getAdoptContentAdoptPriceList(AdoptContentAdoptPriceExportReqVO exportReqVO);

}
