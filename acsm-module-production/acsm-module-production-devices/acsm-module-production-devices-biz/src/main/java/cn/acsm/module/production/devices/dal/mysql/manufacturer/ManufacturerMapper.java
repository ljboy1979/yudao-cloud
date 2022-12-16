package cn.acsm.module.production.devices.dal.mysql.manufacturer;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.production.devices.dal.dataobject.manufacturer.ManufacturerDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.devices.controller.admin.manufacturer.vo.*;

/**
 * 设备厂家 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ManufacturerMapper extends BaseMapperX<ManufacturerDO> {

    default PageResult<ManufacturerDO> selectPage(ManufacturerPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ManufacturerDO>()
                .likeIfPresent(ManufacturerDO::getName, reqVO.getName())
                .betweenIfPresent(ManufacturerDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ManufacturerDO::getSource, reqVO.getSource())
                .eqIfPresent(ManufacturerDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ManufacturerDO::getId));
    }

    default List<ManufacturerDO> selectList(ManufacturerExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ManufacturerDO>()
                .likeIfPresent(ManufacturerDO::getName, reqVO.getName())
                .betweenIfPresent(ManufacturerDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ManufacturerDO::getSource, reqVO.getSource())
                .eqIfPresent(ManufacturerDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ManufacturerDO::getId));
    }

}
