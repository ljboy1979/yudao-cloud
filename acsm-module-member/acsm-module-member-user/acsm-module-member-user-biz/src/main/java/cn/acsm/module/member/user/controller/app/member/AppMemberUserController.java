package cn.acsm.module.member.user.controller.app.member;

import cn.acsm.module.member.user.controller.admin.patient.vo.patienthealth.PatientHealthCreateReqVO;
import cn.acsm.module.member.user.service.member.MemberUserService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "用户 APP - 会员")
@RestController
@RequestMapping("/member/user")
@Validated
@Slf4j
public class AppMemberUserController {

    @Resource
    private MemberUserService userService;

    @PostMapping("/bindPatientHealthInfoByHis")
    @ApiOperation("绑定患者信息通过HIS")
    public CommonResult bindPatientHealthInfoByHis(@RequestBody PatientHealthCreateReqVO patientHealthCreateReqVO) {
        return userService.bindPatientHealthInfoByHis(patientHealthCreateReqVO);
    }

    @PostMapping("/bindPatientHealthInfoNoHis")
    @ApiOperation("绑定患者信息NoHis")
    public CommonResult bindPatientHealthInfoNoHis(@RequestBody PatientHealthCreateReqVO patientHealthCreateReqVO) {
        return userService.bindPatientHealthInfoNoHis(patientHealthCreateReqVO);
    }
}
