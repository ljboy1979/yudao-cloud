package cn.acsm.module.member.wallet.dal.mysql.walletinfo;

import java.util.*;

import cn.acsm.module.member.wallet.controller.admin.walletinfo.vo.UserWalletInfoExportReqVO;
import cn.acsm.module.member.wallet.controller.admin.walletinfo.vo.UserWalletInfoPageReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.member.wallet.dal.dataobject.walletinfo.UserWalletInfoDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户钱包信息 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface UserWalletInfoMapper extends BaseMapperX<UserWalletInfoDO> {

    default PageResult<UserWalletInfoDO> selectPage(UserWalletInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<UserWalletInfoDO>()
                .eqIfPresent(UserWalletInfoDO::getWalletId, reqVO.getWalletId())
                .eqIfPresent(UserWalletInfoDO::getUserId, reqVO.getUserId())
                .likeIfPresent(UserWalletInfoDO::getUsername, reqVO.getUsername())
                .eqIfPresent(UserWalletInfoDO::getPhone, reqVO.getPhone())
                .eqIfPresent(UserWalletInfoDO::getRemark, reqVO.getRemark())
                .eqIfPresent(UserWalletInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(UserWalletInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(UserWalletInfoDO::getId));
    }

    default List<UserWalletInfoDO> selectList(UserWalletInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<UserWalletInfoDO>()
                .eqIfPresent(UserWalletInfoDO::getWalletId, reqVO.getWalletId())
                .eqIfPresent(UserWalletInfoDO::getUserId, reqVO.getUserId())
                .likeIfPresent(UserWalletInfoDO::getUsername, reqVO.getUsername())
                .eqIfPresent(UserWalletInfoDO::getPhone, reqVO.getPhone())
                .eqIfPresent(UserWalletInfoDO::getRemark, reqVO.getRemark())
                .eqIfPresent(UserWalletInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(UserWalletInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(UserWalletInfoDO::getId));
    }

}
