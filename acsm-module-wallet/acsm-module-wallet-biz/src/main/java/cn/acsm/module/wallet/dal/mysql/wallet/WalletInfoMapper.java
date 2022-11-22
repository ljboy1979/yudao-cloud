package cn.acsm.module.wallet.dal.mysql.wallet;

import java.util.*;

import cn.acsm.module.wallet.controller.admin.wallet.vo.WalletInfoExportReqVO;
import cn.acsm.module.wallet.controller.admin.wallet.vo.WalletInfoPageReqVO;
import cn.acsm.module.wallet.dal.dataobject.wallet.WalletInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 钱包信息 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface WalletInfoMapper extends BaseMapperX<WalletInfoDO> {

    default PageResult<WalletInfoDO> selectPage(WalletInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<WalletInfoDO>()
                .eqIfPresent(WalletInfoDO::getWalletNo, reqVO.getWalletNo())
                .eqIfPresent(WalletInfoDO::getMemberId, reqVO.getMemberId())
                .likeIfPresent(WalletInfoDO::getUsername, reqVO.getUsername())
                .eqIfPresent(WalletInfoDO::getPhone, reqVO.getPhone())
                .eqIfPresent(WalletInfoDO::getRemark, reqVO.getRemark())
                .eqIfPresent(WalletInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(WalletInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(WalletInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(WalletInfoDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(WalletInfoDO::getId));
    }

    default List<WalletInfoDO> selectList(WalletInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<WalletInfoDO>()
                .eqIfPresent(WalletInfoDO::getWalletNo, reqVO.getWalletNo())
                .eqIfPresent(WalletInfoDO::getMemberId, reqVO.getMemberId())
                .likeIfPresent(WalletInfoDO::getUsername, reqVO.getUsername())
                .eqIfPresent(WalletInfoDO::getPhone, reqVO.getPhone())
                .eqIfPresent(WalletInfoDO::getRemark, reqVO.getRemark())
                .eqIfPresent(WalletInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(WalletInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(WalletInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(WalletInfoDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(WalletInfoDO::getId));
    }

}
