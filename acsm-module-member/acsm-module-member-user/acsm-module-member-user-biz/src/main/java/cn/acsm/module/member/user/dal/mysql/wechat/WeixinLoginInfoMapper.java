package cn.acsm.module.member.user.dal.mysql.wechat;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.wechat.vo.WeixinLoginInfoExportReqVO;
import cn.acsm.module.member.user.controller.admin.wechat.vo.WeixinLoginInfoPageReqVO;
import cn.acsm.module.member.user.dal.dataobject.wechat.WeixinLoginInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 微信登录信息记录 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface WeixinLoginInfoMapper extends BaseMapperX<WeixinLoginInfoDO> {

    default PageResult<WeixinLoginInfoDO> selectPage(WeixinLoginInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<WeixinLoginInfoDO>()
                .eqIfPresent(WeixinLoginInfoDO::getOpenid, reqVO.getOpenid())
                .eqIfPresent(WeixinLoginInfoDO::getPhone, reqVO.getPhone())
                .eqIfPresent(WeixinLoginInfoDO::getSystemUserId, reqVO.getSystemUserId())
                .eqIfPresent(WeixinLoginInfoDO::getAvatar, reqVO.getAvatar())
                .eqIfPresent(WeixinLoginInfoDO::getProvince, reqVO.getProvince())
                .eqIfPresent(WeixinLoginInfoDO::getCity, reqVO.getCity())
                .likeIfPresent(WeixinLoginInfoDO::getNickName, reqVO.getNickName())
                .eqIfPresent(WeixinLoginInfoDO::getSex, reqVO.getSex())
                .eqIfPresent(WeixinLoginInfoDO::getType, reqVO.getType())
                .eqIfPresent(WeixinLoginInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(WeixinLoginInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(WeixinLoginInfoDO::getId));
    }

    default List<WeixinLoginInfoDO> selectList(WeixinLoginInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<WeixinLoginInfoDO>()
                .eqIfPresent(WeixinLoginInfoDO::getOpenid, reqVO.getOpenid())
                .eqIfPresent(WeixinLoginInfoDO::getPhone, reqVO.getPhone())
                .eqIfPresent(WeixinLoginInfoDO::getSystemUserId, reqVO.getSystemUserId())
                .eqIfPresent(WeixinLoginInfoDO::getAvatar, reqVO.getAvatar())
                .eqIfPresent(WeixinLoginInfoDO::getProvince, reqVO.getProvince())
                .eqIfPresent(WeixinLoginInfoDO::getCity, reqVO.getCity())
                .likeIfPresent(WeixinLoginInfoDO::getNickName, reqVO.getNickName())
                .eqIfPresent(WeixinLoginInfoDO::getSex, reqVO.getSex())
                .eqIfPresent(WeixinLoginInfoDO::getType, reqVO.getType())
                .eqIfPresent(WeixinLoginInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(WeixinLoginInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(WeixinLoginInfoDO::getId));
    }

    @Select(" select id, user_id AS userId,phone AS phone,system_user_id AS systemUserId  from weixin_login_info where deleted ='0' and type = 1 and system_user_id = #{id}  ")
    WeixinLoginInfoDO selectInfoBySystemUserId(@Param("id") String id);

}
