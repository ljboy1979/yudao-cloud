package cn.acsm.module.member.user.dal.mysql.memberuserinfo;

import cn.acsm.module.member.user.controller.admin.memberuserinfo.vo.MemberUserInfoExportReqVO;
import cn.acsm.module.member.user.controller.admin.memberuserinfo.vo.MemberUserInfoPageReqVO;
import cn.acsm.module.member.user.dal.dataobject.memberuserinfo.MemberUserInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户基本信息 Mapper
 *
 * @author lihongyan
 */
@Mapper
public interface MemberUserInfoMapper extends BaseMapperX<MemberUserInfoDO> {

    default PageResult<MemberUserInfoDO> selectPage(MemberUserInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MemberUserInfoDO>()
                .eqIfPresent(MemberUserInfoDO::getMemberUserId, reqVO.getMemberUserId())
                .likeIfPresent(MemberUserInfoDO::getUsername, reqVO.getUsername())
                .likeIfPresent(MemberUserInfoDO::getNickname, reqVO.getNickname())
                .eqIfPresent(MemberUserInfoDO::getInpatientNumber, reqVO.getInpatientNumber())
                .eqIfPresent(MemberUserInfoDO::getWeight, reqVO.getWeight())
                .eqIfPresent(MemberUserInfoDO::getHeight, reqVO.getHeight())
                .eqIfPresent(MemberUserInfoDO::getMedicalAdviceId, reqVO.getMedicalAdviceId())
                .eqIfPresent(MemberUserInfoDO::getBedNumber, reqVO.getBedNumber())
                .eqIfPresent(MemberUserInfoDO::getEmergencyContact, reqVO.getEmergencyContact())
                .eqIfPresent(MemberUserInfoDO::getEmergencyPhone, reqVO.getEmergencyPhone())
                .eqIfPresent(MemberUserInfoDO::getType, reqVO.getType())
                .eqIfPresent(MemberUserInfoDO::getAccount, reqVO.getAccount())
                .eqIfPresent(MemberUserInfoDO::getDepartment, reqVO.getDepartment())
                .eqIfPresent(MemberUserInfoDO::getPartition, reqVO.getPartition())
                .eqIfPresent(MemberUserInfoDO::getBuilding, reqVO.getBuilding())
                .eqIfPresent(MemberUserInfoDO::getFloor, reqVO.getFloor())
                .eqIfPresent(MemberUserInfoDO::getRoom, reqVO.getRoom())
                .eqIfPresent(MemberUserInfoDO::getCardNum, reqVO.getCardNum())
                .eqIfPresent(MemberUserInfoDO::getSex, reqVO.getSex())
                .eqIfPresent(MemberUserInfoDO::getAge, reqVO.getAge())
                .eqIfPresent(MemberUserInfoDO::getMealsAppletQrcodeId, reqVO.getMealsAppletQrcodeId())
                .eqIfPresent(MemberUserInfoDO::getRemark, reqVO.getRemark())
                .eqIfPresent(MemberUserInfoDO::getStatus, reqVO.getStatus())
                .eqIfPresent(MemberUserInfoDO::getLoginIp, reqVO.getLoginIp())
                .betweenIfPresent(MemberUserInfoDO::getLoginDate, reqVO.getLoginDate())
                .betweenIfPresent(MemberUserInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MemberUserInfoDO::getId));
    }

    default List<MemberUserInfoDO> selectList(MemberUserInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MemberUserInfoDO>()
                .eqIfPresent(MemberUserInfoDO::getMemberUserId, reqVO.getMemberUserId())
                .likeIfPresent(MemberUserInfoDO::getUsername, reqVO.getUsername())
                .likeIfPresent(MemberUserInfoDO::getNickname, reqVO.getNickname())
                .eqIfPresent(MemberUserInfoDO::getInpatientNumber, reqVO.getInpatientNumber())
                .eqIfPresent(MemberUserInfoDO::getWeight, reqVO.getWeight())
                .eqIfPresent(MemberUserInfoDO::getHeight, reqVO.getHeight())
                .eqIfPresent(MemberUserInfoDO::getMedicalAdviceId, reqVO.getMedicalAdviceId())
                .eqIfPresent(MemberUserInfoDO::getBedNumber, reqVO.getBedNumber())
                .eqIfPresent(MemberUserInfoDO::getEmergencyContact, reqVO.getEmergencyContact())
                .eqIfPresent(MemberUserInfoDO::getEmergencyPhone, reqVO.getEmergencyPhone())
                .eqIfPresent(MemberUserInfoDO::getType, reqVO.getType())
                .eqIfPresent(MemberUserInfoDO::getAccount, reqVO.getAccount())
                .eqIfPresent(MemberUserInfoDO::getDepartment, reqVO.getDepartment())
                .eqIfPresent(MemberUserInfoDO::getPartition, reqVO.getPartition())
                .eqIfPresent(MemberUserInfoDO::getBuilding, reqVO.getBuilding())
                .eqIfPresent(MemberUserInfoDO::getFloor, reqVO.getFloor())
                .eqIfPresent(MemberUserInfoDO::getRoom, reqVO.getRoom())
                .eqIfPresent(MemberUserInfoDO::getCardNum, reqVO.getCardNum())
                .eqIfPresent(MemberUserInfoDO::getSex, reqVO.getSex())
                .eqIfPresent(MemberUserInfoDO::getAge, reqVO.getAge())
                .eqIfPresent(MemberUserInfoDO::getMealsAppletQrcodeId, reqVO.getMealsAppletQrcodeId())
                .eqIfPresent(MemberUserInfoDO::getRemark, reqVO.getRemark())
                .eqIfPresent(MemberUserInfoDO::getStatus, reqVO.getStatus())
                .eqIfPresent(MemberUserInfoDO::getLoginIp, reqVO.getLoginIp())
                .betweenIfPresent(MemberUserInfoDO::getLoginDate, reqVO.getLoginDate())
                .betweenIfPresent(MemberUserInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MemberUserInfoDO::getId));
    }

}
