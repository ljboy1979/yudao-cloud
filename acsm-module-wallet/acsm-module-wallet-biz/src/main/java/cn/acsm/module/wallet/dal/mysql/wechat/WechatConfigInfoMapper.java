package cn.acsm.module.wallet.dal.mysql.wechat;

import java.util.*;

import cn.acsm.module.wallet.controller.admin.wechat.vo.WechatConfigInfoExportReqVO;
import cn.acsm.module.wallet.controller.admin.wechat.vo.WechatConfigInfoPageReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.acsm.module.wallet.dal.dataobject.wechat.WechatConfigInfoDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 微信支付配置信息 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface WechatConfigInfoMapper extends BaseMapperX<WechatConfigInfoDO> {

    default PageResult<WechatConfigInfoDO> selectPage(WechatConfigInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<WechatConfigInfoDO>()
                .eqIfPresent(WechatConfigInfoDO::getAppId, reqVO.getAppId())
                .eqIfPresent(WechatConfigInfoDO::getAppSecret, reqVO.getAppSecret())
                .eqIfPresent(WechatConfigInfoDO::getMchId, reqVO.getMchId())
                .eqIfPresent(WechatConfigInfoDO::getMchKey, reqVO.getMchKey())
                .eqIfPresent(WechatConfigInfoDO::getRemark, reqVO.getRemark())
                .eqIfPresent(WechatConfigInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(WechatConfigInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(WechatConfigInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(WechatConfigInfoDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(WechatConfigInfoDO::getId));
    }

    default List<WechatConfigInfoDO> selectList(WechatConfigInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<WechatConfigInfoDO>()
                .eqIfPresent(WechatConfigInfoDO::getAppId, reqVO.getAppId())
                .eqIfPresent(WechatConfigInfoDO::getAppSecret, reqVO.getAppSecret())
                .eqIfPresent(WechatConfigInfoDO::getMchId, reqVO.getMchId())
                .eqIfPresent(WechatConfigInfoDO::getMchKey, reqVO.getMchKey())
                .eqIfPresent(WechatConfigInfoDO::getRemark, reqVO.getRemark())
                .eqIfPresent(WechatConfigInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(WechatConfigInfoDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(WechatConfigInfoDO::getSource, reqVO.getSource())
                .eqIfPresent(WechatConfigInfoDO::getSubjectId, reqVO.getSubjectId())
                .orderByDesc(WechatConfigInfoDO::getId));
    }

}
