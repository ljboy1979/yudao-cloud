package cn.acsm.module.service.dal.mysql.serviceinfocarrier;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.service.dal.dataobject.serviceinfocarrier.ServiceInfoCarrierDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.service.controller.admin.serviceinfocarrier.vo.*;

/**
 * 服务-认养物/租凭物 Mapper
 *
 * @author smile
 */
@Mapper
public interface ServiceInfoCarrierMapper extends BaseMapperX<ServiceInfoCarrierDO> {

    default PageResult<ServiceInfoCarrierDO> selectPage(ServiceInfoCarrierPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ServiceInfoCarrierDO>()
                .eqIfPresent(ServiceInfoCarrierDO::getAdoptContentAdoptId, reqVO.getAdoptContentAdoptId())
                .eqIfPresent(ServiceInfoCarrierDO::getServiceInfoId, reqVO.getServiceInfoId())
                .eqIfPresent(ServiceInfoCarrierDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ServiceInfoCarrierDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ServiceInfoCarrierDO::getSource, reqVO.getSource())
                .orderByDesc(ServiceInfoCarrierDO::getId));
    }

    default List<ServiceInfoCarrierDO> selectList(ServiceInfoCarrierExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ServiceInfoCarrierDO>()
                .eqIfPresent(ServiceInfoCarrierDO::getAdoptContentAdoptId, reqVO.getAdoptContentAdoptId())
                .eqIfPresent(ServiceInfoCarrierDO::getServiceInfoId, reqVO.getServiceInfoId())
                .eqIfPresent(ServiceInfoCarrierDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ServiceInfoCarrierDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ServiceInfoCarrierDO::getSource, reqVO.getSource())
                .orderByDesc(ServiceInfoCarrierDO::getId));
    }

}
