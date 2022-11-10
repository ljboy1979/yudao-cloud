package cn.acsm.module.user.user.convert.memberuserinfo;

import java.util.*;

import cn.acsm.module.user.user.controller.admin.memberuserinfo.vo.MemberUserInfoCreateReqVO;
import cn.acsm.module.user.user.controller.admin.memberuserinfo.vo.MemberUserInfoExcelVO;
import cn.acsm.module.user.user.controller.admin.memberuserinfo.vo.MemberUserInfoRespVO;
import cn.acsm.module.user.user.controller.admin.memberuserinfo.vo.MemberUserInfoUpdateReqVO;
import cn.acsm.module.user.user.dal.dataobject.memberuserinfo.MemberUserInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户基本信息 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface MemberUserInfoConvert {

    MemberUserInfoConvert INSTANCE = Mappers.getMapper(MemberUserInfoConvert.class);

    MemberUserInfoDO convert(MemberUserInfoCreateReqVO bean);

    MemberUserInfoDO convert(MemberUserInfoUpdateReqVO bean);

    MemberUserInfoRespVO convert(MemberUserInfoDO bean);

    List<MemberUserInfoRespVO> convertList(List<MemberUserInfoDO> list);

    PageResult<MemberUserInfoRespVO> convertPage(PageResult<MemberUserInfoDO> page);

    List<MemberUserInfoExcelVO> convertList02(List<MemberUserInfoDO> list);

}
