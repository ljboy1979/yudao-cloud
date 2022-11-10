package cn.acsm.module.user.user.dal.mysql.wechat;

import java.util.*;

import cn.acsm.module.user.user.controller.admin.wechat.vo.WeixinDeployInfoBaseVO;
import cn.acsm.module.user.user.controller.admin.wechat.vo.WeixinDeployInfoExportReqVO;
import cn.acsm.module.user.user.controller.admin.wechat.vo.WeixinDeployInfoPageReqVO;
import cn.acsm.module.user.user.dal.dataobject.wechat.WeixinDeployInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 微信公众号配置信息 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface WeixinDeployInfoMapper extends BaseMapperX<WeixinDeployInfoDO> {

    default PageResult<WeixinDeployInfoDO> selectPage(WeixinDeployInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<WeixinDeployInfoDO>()
                .eqIfPresent(WeixinDeployInfoDO::getAppid, reqVO.getAppid())
                .eqIfPresent(WeixinDeployInfoDO::getAppsecret, reqVO.getAppsecret())
                .eqIfPresent(WeixinDeployInfoDO::getMchId, reqVO.getMchId())
                .eqIfPresent(WeixinDeployInfoDO::getMchKey, reqVO.getMchKey())
                .eqIfPresent(WeixinDeployInfoDO::getAppletFlag, reqVO.getAppletFlag())
                .eqIfPresent(WeixinDeployInfoDO::getRemark, reqVO.getRemark())
                .eqIfPresent(WeixinDeployInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(WeixinDeployInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(WeixinDeployInfoDO::getId));
    }

    default List<WeixinDeployInfoDO> selectList(WeixinDeployInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<WeixinDeployInfoDO>()
                .eqIfPresent(WeixinDeployInfoDO::getAppid, reqVO.getAppid())
                .eqIfPresent(WeixinDeployInfoDO::getAppsecret, reqVO.getAppsecret())
                .eqIfPresent(WeixinDeployInfoDO::getMchId, reqVO.getMchId())
                .eqIfPresent(WeixinDeployInfoDO::getMchKey, reqVO.getMchKey())
                .eqIfPresent(WeixinDeployInfoDO::getAppletFlag, reqVO.getAppletFlag())
                .eqIfPresent(WeixinDeployInfoDO::getRemark, reqVO.getRemark())
                .eqIfPresent(WeixinDeployInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(WeixinDeployInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(WeixinDeployInfoDO::getId));
    }

    default List<WeixinDeployInfoDO> selectListByTenantId(WeixinDeployInfoDO weixinDeployInfoDO) {
        return selectList(new LambdaQueryWrapperX<WeixinDeployInfoDO>()
                .eqIfPresent(WeixinDeployInfoDO::getTenantId, weixinDeployInfoDO.getTenantId())
                .eqIfPresent(WeixinDeployInfoDO::getAppletFlag, weixinDeployInfoDO.getAppletFlag())
                .orderByDesc(WeixinDeployInfoDO::getId));
    }

}
