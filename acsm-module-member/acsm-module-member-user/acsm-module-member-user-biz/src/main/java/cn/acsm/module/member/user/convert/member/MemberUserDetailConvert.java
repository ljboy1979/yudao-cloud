package cn.acsm.module.member.user.convert.member;

import java.util.*;

import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserDetailCreateReqVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserDetailExcelVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserDetailRespVO;
import cn.acsm.module.member.user.controller.admin.member.vo.MemberUserDetailUpdateReqVO;
import cn.acsm.module.member.user.dal.dataobject.member.MemberUserDetailDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 会员信息 Convert
 *
 * @author lihongyan
 */
@Mapper
public interface MemberUserDetailConvert {

    MemberUserDetailConvert INSTANCE = Mappers.getMapper(MemberUserDetailConvert.class);

    MemberUserDetailDO convert(MemberUserDetailCreateReqVO bean);

    MemberUserDetailDO convert(MemberUserDetailUpdateReqVO bean);

    MemberUserDetailRespVO convert(MemberUserDetailDO bean);

    List<MemberUserDetailRespVO> convertList(List<MemberUserDetailDO> list);

    PageResult<MemberUserDetailRespVO> convertPage(PageResult<MemberUserDetailDO> page);

    List<MemberUserDetailExcelVO> convertList02(List<MemberUserDetailDO> list);

}
