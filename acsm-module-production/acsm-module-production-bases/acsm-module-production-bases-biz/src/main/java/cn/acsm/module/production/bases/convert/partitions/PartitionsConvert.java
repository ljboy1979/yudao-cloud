package cn.acsm.module.production.bases.convert.partitions;

import java.util.*;

import cn.acsm.module.production.bases.controller.admin.partitions.vo.PartitionsCreateReqVO;
import cn.acsm.module.production.bases.controller.admin.partitions.vo.PartitionsExcelVO;
import cn.acsm.module.production.bases.controller.admin.partitions.vo.PartitionsRespVO;
import cn.acsm.module.production.bases.controller.admin.partitions.vo.PartitionsUpdateReqVO;
import cn.acsm.module.production.bases.dal.dataobject.partitions.PartitionsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.acsm.module.production.bases.controller.admin.partitions.vo.*;

/**
 * 分区信息 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface PartitionsConvert {

    PartitionsConvert INSTANCE = Mappers.getMapper(PartitionsConvert.class);

    PartitionsDO convert(PartitionsCreateReqVO bean);

    PartitionsDO convert(PartitionsUpdateReqVO bean);

    PartitionsRespVO convert(PartitionsDO bean);

    List<PartitionsRespVO> convertList(List<PartitionsDO> list);

    PageResult<PartitionsRespVO> convertPage(PageResult<PartitionsDO> page);

    List<PartitionsExcelVO> convertList02(List<PartitionsDO> list);

}
