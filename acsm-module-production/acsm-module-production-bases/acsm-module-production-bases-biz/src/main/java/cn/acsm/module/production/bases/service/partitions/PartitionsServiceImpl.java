package cn.acsm.module.production.bases.service.partitions;

import cn.acsm.module.production.bases.controller.admin.partitions.vo.PartitionsCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.partitions.vo.PartitionsExportReqVO;
import cn.acsm.module.production.bases.controller.admin.partitions.vo.PartitionsPageReqVO;
import cn.acsm.module.production.bases.controller.admin.partitions.vo.PartitionsUpdateReqVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.acsm.module.production.bases.controller.admin.partitions.vo.*;
import cn.acsm.module.production.bases.dal.dataobject.partitions.PartitionsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.acsm.module.production.bases.convert.partitions.PartitionsConvert;
import cn.acsm.module.production.bases.dal.mysql.partitions.PartitionsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.production.bases.enums.ErrorCodeConstants.*;

/**
 * 分区信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PartitionsServiceImpl implements PartitionsService {

    @Resource
    private PartitionsMapper partitionsMapper;

    @Override
    public Long createPartitions(PartitionsCreateReqVO createReqVO) {
        // 插入
        PartitionsDO partitions = PartitionsConvert.INSTANCE.convert(createReqVO);
        partitionsMapper.insert(partitions);
        // 返回
        return partitions.getId();
    }

    @Override
    public void updatePartitions(PartitionsUpdateReqVO updateReqVO) {
        // 校验存在
        this.validatePartitionsExists(updateReqVO.getId());
        // 更新
        PartitionsDO updateObj = PartitionsConvert.INSTANCE.convert(updateReqVO);
        partitionsMapper.updateById(updateObj);
    }

    @Override
    public void deletePartitions(Long id) {
        // 校验存在
        this.validatePartitionsExists(id);
        // 删除
        partitionsMapper.deleteById(id);
    }

    private void validatePartitionsExists(Long id) {
        if (partitionsMapper.selectById(id) == null) {
            throw exception(PARTITIONS_NOT_EXISTS);
        }
    }

    @Override
    public PartitionsDO getPartitions(Long id) {
        return partitionsMapper.selectById(id);
    }

    @Override
    public List<PartitionsDO> getPartitionsList(Collection<Long> ids) {
        return partitionsMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PartitionsDO> getPartitionsPage(PartitionsPageReqVO pageReqVO) {
        return partitionsMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PartitionsDO> getPartitionsList(PartitionsExportReqVO exportReqVO) {
        return partitionsMapper.selectList(exportReqVO);
    }

}
