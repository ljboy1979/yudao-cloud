package cn.acsm.module.enterprise.dal.mysql.otheraccountinfo;

import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoExportReqVO;
import cn.acsm.module.enterprise.controller.admin.otheraccountinfo.vo.OtherAccountInfoPageReqVO;
import cn.acsm.module.enterprise.dal.dataobject.otheraccountinfo.OtherAccountInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 经营主体其他账户 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface OtherAccountInfoMapper extends BaseMapperX< OtherAccountInfoDO > {

    default PageResult<OtherAccountInfoDO> selectPage(OtherAccountInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<OtherAccountInfoDO>()
                .likeIfPresent(OtherAccountInfoDO::getAccountName, reqVO.getAccountName())
                .eqIfPresent(OtherAccountInfoDO::getAccountNo, reqVO.getAccountNo())
                .eqIfPresent(OtherAccountInfoDO::getAccountIdCard, reqVO.getAccountIdCard())
                .eqIfPresent(OtherAccountInfoDO::getAccountBank, reqVO.getAccountBank())
                .betweenIfPresent(OtherAccountInfoDO::getCreateTime, reqVO.getCreateTime())
                .betweenIfPresent(OtherAccountInfoDO::getUpdateTime, reqVO.getUpdateTime())
                .orderByDesc(OtherAccountInfoDO::getId));
    }

    default List<OtherAccountInfoDO> selectList(OtherAccountInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<OtherAccountInfoDO>()
                .likeIfPresent(OtherAccountInfoDO::getAccountName, reqVO.getAccountName())
                .eqIfPresent(OtherAccountInfoDO::getAccountNo, reqVO.getAccountNo())
                .eqIfPresent(OtherAccountInfoDO::getAccountIdCard, reqVO.getAccountIdCard())
                .eqIfPresent(OtherAccountInfoDO::getAccountBank, reqVO.getAccountBank())
                .betweenIfPresent(OtherAccountInfoDO::getCreateTime, reqVO.getCreateTime())
                .betweenIfPresent(OtherAccountInfoDO::getUpdateTime, reqVO.getUpdateTime())
                .orderByDesc(OtherAccountInfoDO::getId));
    }

}
