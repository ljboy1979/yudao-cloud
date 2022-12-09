package cn.acsm.module.service.dal.mysql.customerlist;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.service.dal.dataobject.customerlist.CustomerListDO;
import org.apache.ibatis.annotations.Mapper;
import cn.acsm.module.service.controller.admin.customerlist.vo.*;

/**
 * 服务客户名单 Mapper
 *
 * @author smile
 */
@Mapper
public interface CustomerListMapper extends BaseMapperX<CustomerListDO> {

    default PageResult<CustomerListDO> selectPage(CustomerListPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CustomerListDO>()
                .eqIfPresent(CustomerListDO::getIdentityCode, reqVO.getIdentityCode())
                .likeIfPresent(CustomerListDO::getParticipantName, reqVO.getParticipantName())
                .eqIfPresent(CustomerListDO::getCellphoneNumber, reqVO.getCellphoneNumber())
                .eqIfPresent(CustomerListDO::getIdNumber, reqVO.getIdNumber())
                .eqIfPresent(CustomerListDO::getGender, reqVO.getGender())
                .eqIfPresent(CustomerListDO::getServiceOrderId, reqVO.getServiceOrderId())
                .eqIfPresent(CustomerListDO::getPayee, reqVO.getPayee())
                .eqIfPresent(CustomerListDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(CustomerListDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(CustomerListDO::getSource, reqVO.getSource())
                .orderByDesc(CustomerListDO::getId));
    }

    default List<CustomerListDO> selectList(CustomerListExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<CustomerListDO>()
                .eqIfPresent(CustomerListDO::getIdentityCode, reqVO.getIdentityCode())
                .likeIfPresent(CustomerListDO::getParticipantName, reqVO.getParticipantName())
                .eqIfPresent(CustomerListDO::getCellphoneNumber, reqVO.getCellphoneNumber())
                .eqIfPresent(CustomerListDO::getIdNumber, reqVO.getIdNumber())
                .eqIfPresent(CustomerListDO::getGender, reqVO.getGender())
                .eqIfPresent(CustomerListDO::getServiceOrderId, reqVO.getServiceOrderId())
                .eqIfPresent(CustomerListDO::getPayee, reqVO.getPayee())
                .eqIfPresent(CustomerListDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(CustomerListDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(CustomerListDO::getSource, reqVO.getSource())
                .orderByDesc(CustomerListDO::getId));
    }

}
