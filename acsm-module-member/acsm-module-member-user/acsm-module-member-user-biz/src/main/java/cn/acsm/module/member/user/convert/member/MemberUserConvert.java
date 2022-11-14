package cn.acsm.module.member.user.convert.member;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserCreateReqVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserExcelVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserRespVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.member.MemberUserDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 会员 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface MemberUserConvert {

    MemberUserConvert INSTANCE = Mappers.getMapper(MemberUserConvert.class);

    MemberUserDO convert(MemberUserCreateReqVO bean);

    MemberUserDO convert(MemberUserUpdateReqVO bean);

    MemberUserRespVO convert(MemberUserDO bean);

    List<MemberUserRespVO> convertList(List<MemberUserDO> list);

    PageResult<MemberUserRespVO> convertPage(PageResult<MemberUserDO> page);

    List<MemberUserExcelVO> convertList02(List<MemberUserDO> list);

}
