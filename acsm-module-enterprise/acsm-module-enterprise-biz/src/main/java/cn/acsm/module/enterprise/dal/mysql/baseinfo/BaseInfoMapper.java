package cn.acsm.module.enterprise.dal.mysql.baseinfo;

import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoExportReqVO;
import cn.acsm.module.enterprise.controller.admin.baseinfo.vo.BaseInfoPageReqVO;
import cn.acsm.module.enterprise.dal.dataobject.baseinfo.BaseInfoDO;
import cn.acsm.module.enterprise.enums.enterprisebaseinfo.EnterpriseStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 经营主体 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface BaseInfoMapper extends BaseMapperX< BaseInfoDO > {

    default PageResult<BaseInfoDO> selectPage(BaseInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BaseInfoDO>()
                .eqIfPresent(BaseInfoDO::getId, reqVO.getId())
                .eqIfPresent(BaseInfoDO::getCode, reqVO.getCode())
                .likeIfPresent(BaseInfoDO::getName, reqVO.getName())
                .eqIfPresent(BaseInfoDO::getEnterpriseType, reqVO.getEnterpriseType())
                .likeIfPresent(BaseInfoDO::getEnterpriseTypeName, reqVO.getEnterpriseTypeName())
                .eqIfPresent(BaseInfoDO::getStauts, reqVO.getStauts())
                .eqIfPresent(BaseInfoDO::getUserTag, reqVO.getUserTag())
                .likeIfPresent(BaseInfoDO::getUserTagName, reqVO.getUserTagName())
                .eqIfPresent(BaseInfoDO::getManageStatus, reqVO.getManageStatus())
//                .betweenIfPresent(BaseInfoDO::getRegisterTime, reqVO.getRegisterTime())
                .betweenIfPresent(BaseInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BaseInfoDO::getId));
    }

    default List<BaseInfoDO> selectList(BaseInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<BaseInfoDO>()
                .eqIfPresent(BaseInfoDO::getId, reqVO.getId())
                .eqIfPresent(BaseInfoDO::getCode, reqVO.getCode())
                .likeIfPresent(BaseInfoDO::getName, reqVO.getName())
                .eqIfPresent(BaseInfoDO::getEnterpriseType, reqVO.getEnterpriseType())
                .likeIfPresent(BaseInfoDO::getEnterpriseTypeName, reqVO.getEnterpriseTypeName())
                .eqIfPresent(BaseInfoDO::getStauts, reqVO.getStauts())
                .eqIfPresent(BaseInfoDO::getUserTag, reqVO.getUserTag())
                .likeIfPresent(BaseInfoDO::getUserTagName, reqVO.getUserTagName())
                .eqIfPresent(BaseInfoDO::getManageStatus, reqVO.getManageStatus())
                .betweenIfPresent(BaseInfoDO::getCreateTime, reqVO.getCreateTime())
//                .betweenIfPresent(BaseInfoDO::getRegisterTime, reqVO.getRegisterTime())
                .orderByDesc(BaseInfoDO::getId));
    }
    default List<BaseInfoDO> findSelectList() {
        return selectList(new LambdaQueryWrapperX<BaseInfoDO>()
                .eqIfPresent(BaseInfoDO::getStauts, EnterpriseStatusEnum.NORMAL.getStatus())
                .orderByDesc(BaseInfoDO::getId));
    }

}
