package cn.acsm.module.production.bases.service.partitions;

import java.util.*;
import javax.validation.*;

import cn.acsm.module.production.bases.controller.admin.partitions.vo.PartitionsCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.partitions.vo.PartitionsExportReqVO;
import cn.acsm.module.production.bases.controller.admin.partitions.vo.PartitionsPageReqVO;
import cn.acsm.module.production.bases.controller.admin.partitions.vo.PartitionsUpdateReqVO;
import cn.acsm.module.production.bases.dal.dataobject.partitions.PartitionsDO;
import cn.acsm.module.production.bases.controller.admin.partitions.vo.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 分区信息 Service 接口
 *
 * @author 芋道源码
 */
public interface PartitionsService {

    /**
     * 创建分区信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPartitions(@Valid PartitionsCreateReqVO createReqVO);

    /**
     * 更新分区信息
     *
     * @param updateReqVO 更新信息
     */
    void updatePartitions(@Valid PartitionsUpdateReqVO updateReqVO);

    /**
     * 删除分区信息
     *
     * @param id 编号
     */
    void deletePartitions(Long id);

    /**
     * 获得分区信息
     *
     * @param id 编号
     * @return 分区信息
     */
    PartitionsDO getPartitions(Long id);

    /**
     * 获得分区信息列表
     *
     * @param ids 编号
     * @return 分区信息列表
     */
    List<PartitionsDO> getPartitionsList(Collection<Long> ids);

    /**
     * 获得分区信息分页
     *
     * @param pageReqVO 分页查询
     * @return 分区信息分页
     */
    PageResult<PartitionsDO> getPartitionsPage(PartitionsPageReqVO pageReqVO);

    /**
     * 获得分区信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 分区信息列表
     */
    List<PartitionsDO> getPartitionsList(PartitionsExportReqVO exportReqVO);

}
