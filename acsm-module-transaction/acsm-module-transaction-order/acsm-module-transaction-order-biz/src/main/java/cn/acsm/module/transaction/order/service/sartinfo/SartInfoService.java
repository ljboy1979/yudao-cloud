package cn.acsm.module.transaction.order.service.sartinfo;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.order.controller.admin.sartinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.sartinfo.SartInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 购物车 Service 接口
 *
 * @author 芋道源码
 */
public interface SartInfoService {

    /**
     * 创建购物车
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createSartInfo(@Valid SartInfoCreateReqVO createReqVO);

    /**
     * 更新购物车
     *
     * @param updateReqVO 更新信息
     */
    void updateSartInfo(@Valid SartInfoUpdateReqVO updateReqVO);

    /**
     * 删除购物车
     *
     * @param id 编号
     */
    void deleteSartInfo(String id);

    /**
     * 获得购物车
     *
     * @param id 编号
     * @return 购物车
     */
    SartInfoDO getSartInfo(String id);

    /**
     * 获得购物车列表
     *
     * @param ids 编号
     * @return 购物车列表
     */
    List<SartInfoDO> getSartInfoList(Collection<String> ids);

    /**
     * 获得购物车分页
     *
     * @param pageReqVO 分页查询
     * @return 购物车分页
     */
    PageResult<SartInfoDO> getSartInfoPage(SartInfoPageReqVO pageReqVO);

    /**
     * 获得购物车列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 购物车列表
     */
    List<SartInfoDO> getSartInfoList(SartInfoExportReqVO exportReqVO);

}
