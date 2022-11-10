package cn.acsm.module.user.user.convert.user;

import java.util.*;

import cn.acsm.module.user.user.controller.admin.user.vo.MemberUserCreateReqVO;
import cn.acsm.module.user.user.controller.admin.user.vo.MemberUserExcelVO;
import cn.acsm.module.user.user.controller.admin.user.vo.MemberUserRespVO;
import cn.acsm.module.user.user.dal.dataobject.user.MemberUserDO;
import cn.acsm.module.user.user.controller.admin.user.vo.MemberUserUpdateReqVO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户 Convert
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
