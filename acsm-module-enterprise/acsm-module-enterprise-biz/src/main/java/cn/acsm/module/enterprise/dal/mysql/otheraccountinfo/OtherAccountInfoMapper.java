package cn.acsm.module.enterprise.dal.mysql.otheraccountinfo;

import java.util.*;

import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoExportReqVO;
import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoPageReqVO;
import cn.acsm.module.enterprise.dal.dataobject.otheraccountinfo.OtherAccountInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 经营主体其他账户 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface OtherAccountInfoMapper extends BaseMapperX< OtherAccountInfoDO > {

    default PageResult<OtherAccountInfoDO> selectPage(OtherAccountInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<OtherAccountInfoDO>()
                .eqIfPresent(OtherAccountInfoDO::getEnterpriseId, reqVO.getEnterpriseId())
                .likeIfPresent(OtherAccountInfoDO::getAccountName, reqVO.getAccountName())
                .eqIfPresent(OtherAccountInfoDO::getAccountNo, reqVO.getAccountNo())
                .eqIfPresent(OtherAccountInfoDO::getAccountIdCard, reqVO.getAccountIdCard())
                .eqIfPresent(OtherAccountInfoDO::getAccountBank, reqVO.getAccountBank())
                .eqIfPresent(OtherAccountInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(OtherAccountInfoDO::getSubjectId, reqVO.getSubjectId())
                .betweenIfPresent(OtherAccountInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(OtherAccountInfoDO::getId));
    }

    default List<OtherAccountInfoDO> selectList(OtherAccountInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<OtherAccountInfoDO>()
                .eqIfPresent(OtherAccountInfoDO::getEnterpriseId, reqVO.getEnterpriseId())
                .likeIfPresent(OtherAccountInfoDO::getAccountName, reqVO.getAccountName())
                .eqIfPresent(OtherAccountInfoDO::getAccountNo, reqVO.getAccountNo())
                .eqIfPresent(OtherAccountInfoDO::getAccountIdCard, reqVO.getAccountIdCard())
                .eqIfPresent(OtherAccountInfoDO::getAccountBank, reqVO.getAccountBank())
                .eqIfPresent(OtherAccountInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(OtherAccountInfoDO::getSubjectId, reqVO.getSubjectId())
                .betweenIfPresent(OtherAccountInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(OtherAccountInfoDO::getId));
    }

}
