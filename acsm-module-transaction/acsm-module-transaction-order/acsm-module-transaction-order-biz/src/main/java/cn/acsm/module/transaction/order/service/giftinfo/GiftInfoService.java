package cn.acsm.module.transaction.order.service.giftinfo;

import java.util.*;
import javax.validation.*;
import cn.acsm.module.transaction.order.controller.admin.giftinfo.vo.*;
import cn.acsm.module.transaction.order.dal.dataobject.giftinfo.GiftInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 赠品 Service 接口
 *
 * @author 芋道源码
 */
public interface GiftInfoService {

    /**
     * 创建赠品
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createGiftInfo(@Valid GiftInfoCreateReqVO createReqVO);

    /**
     * 更新赠品
     *
     * @param updateReqVO 更新信息
     */
    void updateGiftInfo(@Valid GiftInfoUpdateReqVO updateReqVO);

    /**
     * 删除赠品
     *
     * @param id 编号
     */
    void deleteGiftInfo(Integer id);

    /**
     * 获得赠品
     *
     * @param id 编号
     * @return 赠品
     */
    GiftInfoDO getGiftInfo(Integer id);

    /**
     * 获得赠品列表
     *
     * @param ids 编号
     * @return 赠品列表
     */
    List<GiftInfoDO> getGiftInfoList(Collection<Integer> ids);

    /**
     * 获得赠品分页
     *
     * @param pageReqVO 分页查询
     * @return 赠品分页
     */
    PageResult<GiftInfoDO> getGiftInfoPage(GiftInfoPageReqVO pageReqVO);

    /**
     * 获得赠品列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 赠品列表
     */
    List<GiftInfoDO> getGiftInfoList(GiftInfoExportReqVO exportReqVO);

}
