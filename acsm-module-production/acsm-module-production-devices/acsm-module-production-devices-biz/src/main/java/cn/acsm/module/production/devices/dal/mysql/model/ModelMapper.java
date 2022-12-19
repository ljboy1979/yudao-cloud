package cn.acsm.module.production.devices.dal.mysql.model;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.production.devices.dal.dataobject.model.ModelDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.production.devices.controller.admin.model.vo.*;

/**
 * 设备型号 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ModelMapper extends BaseMapperX<ModelDO> {

    default PageResult<ModelDO> selectPage(ModelPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ModelDO>()
                .eqIfPresent(ModelDO::getManufacturerId, reqVO.getManufacturerId())
                .likeIfPresent(ModelDO::getName, reqVO.getName())
                .betweenIfPresent(ModelDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ModelDO::getSource, reqVO.getSource())
                .eqIfPresent(ModelDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ModelDO::getId));
    }

    default List<ModelDO> selectList(ModelExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ModelDO>()
                .eqIfPresent(ModelDO::getManufacturerId, reqVO.getManufacturerId())
                .likeIfPresent(ModelDO::getName, reqVO.getName())
                .betweenIfPresent(ModelDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ModelDO::getSource, reqVO.getSource())
                .eqIfPresent(ModelDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(ModelDO::getId));
    }

}
