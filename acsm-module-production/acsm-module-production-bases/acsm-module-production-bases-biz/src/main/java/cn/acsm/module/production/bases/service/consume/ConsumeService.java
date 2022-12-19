package cn.acsm.module.production.bases.service.consume;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.production.bases.controller.admin.consume.vo.ConsumeCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.consume.vo.ConsumeExportReqVO;
import cn.acsm.module.production.bases.controller.admin.consume.vo.ConsumePageReqVO;
import cn.acsm.module.production.bases.controller.admin.consume.vo.ConsumeUpdateReqVO;
import cn.acsm.module.production.bases.dal.dataobject.consume.ConsumeDO;
import cn.acsm.module.production.bases.controller.admin.consume.vo.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 基地能耗信息 Service 接口
 *
 * @author 芋道源码
 */
public interface ConsumeService {

    /**
     * 创建基地能耗信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createConsume(@Valid ConsumeCreateReqVO createReqVO);

    /**
     * 更新基地能耗信息
     *
     * @param updateReqVO 更新信息
     */
    void updateConsume(@Valid ConsumeUpdateReqVO updateReqVO);

    /**
     * 删除基地能耗信息
     *
     * @param id 编号
     */
    void deleteConsume(Long id);

    /**
     * 获得基地能耗信息
     *
     * @param id 编号
     * @return 基地能耗信息
     */
    ConsumeDO getConsume(Long id);

    /**
     * 获得基地能耗信息列表
     *
     * @param ids 编号
     * @return 基地能耗信息列表
     */
    List<ConsumeDO> getConsumeList(Collection<Long> ids);

    /**
     * 获得基地能耗信息分页
     *
     * @param pageReqVO 分页查询
     * @return 基地能耗信息分页
     */
    PageResult<ConsumeDO> getConsumePage(ConsumePageReqVO pageReqVO);

    /**
     * 获得基地能耗信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 基地能耗信息列表
     */
    List<ConsumeDO> getConsumeList(ConsumeExportReqVO exportReqVO);

}
