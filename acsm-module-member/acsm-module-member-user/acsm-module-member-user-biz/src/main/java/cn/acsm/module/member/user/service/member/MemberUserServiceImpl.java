package cn.acsm.module.member.user.service.member;

import cn.acsm.module.member.user.api.member.dto.MemberUserReqDTO;
import cn.acsm.module.member.user.controller.admin.member.vo.*;
import cn.acsm.module.member.user.controller.admin.patient.vo.patienthealth.PatientHealthCreateReqVO;
import cn.acsm.module.member.user.convert.member.MemberUserConvert;
import cn.acsm.module.member.user.dal.dataobject.member.MemberUserDO;
import cn.acsm.module.member.user.dal.dataobject.patienthealth.PatientHealthDO;
import cn.acsm.module.member.user.dal.mysql.member.MemberUserMapper;
import cn.acsm.module.member.user.dal.mysql.patienthealth.PatientHealthMapper;
import cn.acsm.module.member.user.service.patienthealth.PatientHealthService;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.monitor.TracerUtils;
import cn.iocoder.yudao.framework.common.util.servlet.ServletUtils;
import cn.iocoder.yudao.module.system.api.logger.LoginLogApi;
import cn.iocoder.yudao.module.system.api.logger.dto.LoginLogCreateReqDTO;
import cn.iocoder.yudao.module.system.enums.logger.LoginLogTypeEnum;
import cn.iocoder.yudao.module.system.enums.logger.LoginResultEnum;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;

import static cn.acsm.module.member.user.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.servlet.ServletUtils.getClientIP;

/**
 * 会员 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
@Slf4j
public class MemberUserServiceImpl implements MemberUserService {

    @Resource
    private MemberUserMapper userMapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private PatientHealthService patientHealthService;
    @Resource
    private PatientHealthMapper patientHealthMapper;
    @Resource
    private LoginLogApi loginLogApi;

    @Resource
    private MemberUserDetailService memberUserDetailService;

    @Override
    public Long createUser(MemberUserCreateReqVO createReqVO) {
        // 插入
        MemberUserDO user = MemberUserConvert.INSTANCE.convert(createReqVO);
        userMapper.insert(user);
        // 返回
        return user.getId();
    }

    @Override
    public void updateUser(MemberUserUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateUserExists(updateReqVO.getId());
        // 更新
        MemberUserDO updateObj = MemberUserConvert.INSTANCE.convert(updateReqVO);
        userMapper.updateById(updateObj);
    }

    @Override
    public void deleteUser(Long id) {
        // 校验存在
        this.validateUserExists(id);
        // 删除
        userMapper.deleteById(id);
    }

    private void validateUserExists(Long id) {
        if (userMapper.selectById(id) == null) {
            throw exception(USER_NOT_EXISTS);
        }
    }

    @Override
    public MemberUserDO getUser(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<MemberUserDO> getUserList(Collection<Long> ids) {
        return userMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MemberUserDO> getUserPage(MemberUserPageReqVO pageReqVO) {
        return userMapper.selectPage(pageReqVO);
    }

    @Override
    public PageResult<MemberUserRespVO> getUserPage4Query(MemberUserPageReqVO pageReqVO) {
        int pageStart = (pageReqVO.getPageNo() - 1) * pageReqVO.getPageSize();
        pageReqVO.setPageNo(pageStart);
        List<MemberUserRespVO> memberUserList = userMapper.selectList4Query(pageReqVO);
        Long total = userMapper.selectList4QueryTotal(pageReqVO);
        PageResult pageResult = new PageResult();
        pageResult.setList(memberUserList);
        pageResult.setTotal(total);
        return pageResult;
    }

    @Override
    public List<MemberUserDO> getUserList(MemberUserExportReqVO exportReqVO) {
        return userMapper.selectList(exportReqVO);
    }

    @Override
    public MemberUserDO createUserIfAbsent(MemberUserReqDTO memberUserReqDTO) {
        // 用户已经存在
        MemberUserDO user = userMapper.selectByMobile(memberUserReqDTO.getMobile());
        if (user != null) {
            return user;
        }
        // 用户不存在，则进行创建
        return this.createUser(memberUserReqDTO);
    }

    private MemberUserDO createUser(MemberUserReqDTO memberUserReqDTO) {
        // 生成密码
        String password = IdUtil.fastSimpleUUID();
        // 插入用户
        MemberUserDO user = new MemberUserDO();
        user.setMobile(memberUserReqDTO.getMobile());
        user.setStatus(CommonStatusEnum.ENABLE.getStatus()); // 默认开启
        user.setPassword(encodePassword(password)); // 加密密码
        user.setRegisterIp(memberUserReqDTO.getRegisterIp());
        user.setSource(memberUserReqDTO.getSource());
        userMapper.insert(user);

        // 插入会员信息数据
        String format = DateUtil.format(new Date(System.currentTimeMillis()),"yyyyMMddHHmmss");
        MemberUserDetailCreateReqVO createDetailReqVO = new MemberUserDetailCreateReqVO();
        createDetailReqVO.setMemberId(user.getId());
        createDetailReqVO.setMemberType(0);
        createDetailReqVO.setAuditStatus(0);
        createDetailReqVO.setMemberRole(0);
        String random = ""+ Math.random();
        createDetailReqVO.setMemberAccount("HY-"+format+(random.substring(random.length()-4)));
        memberUserDetailService.createUserDetail(createDetailReqVO);

        return user;
    }

    public static void main(String[] args) {
        for(int i = 0 ; i <= 20 ; i ++){
            String format = DateUtil.format(new Date(System.currentTimeMillis()),"yyyyMMddHHmmss");
            String random = ""+ Math.random();
            System.out.println("HY-"+format+(random.substring(random.length()-4)));
        }
    }

    /**
     * 对密码进行加密
     *
     * @param password 密码
     * @return 加密后的密码
     */
    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }


    @Override
    public void updateUserLogin(Long id, String loginIp) {
        userMapper.updateById(new MemberUserDO().setId(id)
                .setLoginIp(loginIp).setLoginDate(new Date()));
    }


    /**
     * @Description:注册插入登陆日志
     * @param userId
     * @param mobile
     * @param logType
     * @param loginResult
     * @Date: 2022/11/17
     * @author: lihongyan
     * @throws
     * @return:void
     */
    @Override
    public void createLoginLog(Long userId, String mobile, LoginLogTypeEnum logType, LoginResultEnum loginResult) {
        // 插入登录日志
        LoginLogCreateReqDTO reqDTO = new LoginLogCreateReqDTO();
        reqDTO.setLogType(logType.getType());
        reqDTO.setTraceId(TracerUtils.getTraceId());
        reqDTO.setUserId(userId);
        reqDTO.setUserType(UserTypeEnum.MEMBER.getValue());
        reqDTO.setUsername(mobile);
        reqDTO.setUserAgent(ServletUtils.getUserAgent());
        reqDTO.setUserIp(getClientIP());
        reqDTO.setResult(loginResult.getResult());
        loginLogApi.createLoginLog(reqDTO);
        // 更新最后登录时间
        if (userId != null && Objects.equals(LoginResultEnum.SUCCESS.getResult(), loginResult.getResult())) {
            this.updateUserLogin(userId, getClientIP());
        }
    }

    /**
     * @Description:绑定患者信息
     * @param
     * @Date: 2022/11/22
     * @author: lihongyan
     * @throws
     * @return:cn.iocoder.yudao.framework.common.pojo.CommonResult
     */
    @Override
    public CommonResult bindPatientHealthInfoByHis(PatientHealthCreateReqVO patientHealthCreateReqVO) {
        // 会员ID必传
        if (Objects.isNull(patientHealthCreateReqVO.getMemberId())){
            CommonResult.error(MEMBER_ID_NOT_EXISTS);
        }
        // 查询该会员是否已绑定健康档案
        QueryWrapper<PatientHealthDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Objects.isNull(patientHealthCreateReqVO.getMemberId()),"member_id", patientHealthCreateReqVO.getMemberId());
        queryWrapper.eq(Objects.isNull(patientHealthCreateReqVO.getSource()), "source",patientHealthCreateReqVO.getSource());
        queryWrapper.eq(Objects.isNull(patientHealthCreateReqVO.getTenantId()), "tenant_id",patientHealthCreateReqVO.getTenantId());
        queryWrapper.eq(Objects.isNull(patientHealthCreateReqVO.getSubjectId()), "subject_id",patientHealthCreateReqVO.getSubjectId());
        queryWrapper.eq("deleted","0");
        PatientHealthDO patientHealthCheck = patientHealthMapper.selectOne(queryWrapper);
//        PatientHealthDO patientHealthCheck = patientHealthMapper.selectByMemberId(patientHealthCreateReqVO);
        if (patientHealthCheck != null) {
            return CommonResult.error(PATIENT_HEALTH_BOUND);
        }
        // TODO 根据HIS接口获取数据
        String data="[{\\\"XINGMING\\\":\\\"测试\\\",\\\"XINGBIE\\\":\\\"女\\\",\\\"NIANLING\\\":3.0,\\\"SHENGAO\\\":\\\"100\\\",\\\"TIZHONG\\\":\\\"13.30\\\",\\\"JIATINGDH\\\":\\\"13039333305\\\",\\\"LIANXIREN\\\":\\\"测试\\\",\\\"LIANXIRDH\\\":\\\"13339333305\\\",\\\"DANGQIANKSMC\\\":\\\"儿外科\\\",\\\"DANGQIANBQMC\\\":\\\"5层三疗区儿外科\\\",\\\"DANGQIANCW\\\":\\\"547-2\\\",\\\"YIZHUMC\\\":\\\"禁食水\\\"},{\\\"XINGMING\\\":\\\"测试\\\",\\\"XINGBIE\\\":\\\"女\\\",\\\"NIANLING\\\":3.0,\\\"SHENGAO\\\":\\\"100\\\",\\\"TIZHONG\\\":\\\"13.30\\\",\\\"JIATINGDH\\\":\\\"13339333305\\\",\\\"LIANXIREN\\\":\\\"测试\\\",\\\"LIANXIRDH\\\":\\\"13039333305\\\",\\\"DANGQIANKSMC\\\":\\\"儿外科\\\",\\\"DANGQIANBQMC\\\":\\\"5层三疗区儿外科\\\",\\\"DANGQIANCW\\\":\\\"547-2\\\",\\\"YIZHUMC\\\":\\\"Ⅰ级护理（按小时）\\\"}]";
        String s= StringEscapeUtils.unescapeJava(data);
        log.info("his系统返回信息" +s);
        if (s.equals("[]") || s.equals("null") || s.isEmpty()) {
            return CommonResult.error(HOSPITAL_HIS_NOT_REGISTERED);
        }
        Gson gson = new Gson();
        List<Object> mList = gson.fromJson(s, new TypeToken<List<Object>>() {
        }.getType());

        // 保存HIS系统返回的患者数据
        Map meal = (Map) mList.get(0);
        String YIZHUMC = (String) meal.get("YIZHUMC");
        log.info("姓名及医嘱" + (String) meal.get("XINGMING") + YIZHUMC);

        // 查询会员信息并修改姓名
        QueryWrapper<MemberUserDO> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq(Objects.isNull(patientHealthCreateReqVO.getMemberId()),"member_id", patientHealthCreateReqVO.getMemberId());
        userQueryWrapper.eq(Objects.isNull(patientHealthCreateReqVO.getSource()), "source",patientHealthCreateReqVO.getSource());
        userQueryWrapper.eq(Objects.isNull(patientHealthCreateReqVO.getTenantId()), "tenant_id",patientHealthCreateReqVO.getTenantId());
        userQueryWrapper.eq(Objects.isNull(patientHealthCreateReqVO.getSubjectId()), "subject_id",patientHealthCreateReqVO.getSubjectId());
        userQueryWrapper.eq("deleted","0");
        MemberUserDO memberUserDO = userMapper.selectOne(userQueryWrapper);
        MemberUserUpdateReqVO updateReqVO = new MemberUserUpdateReqVO();
        updateReqVO.setId(memberUserDO.getId());
        updateReqVO.setNickname((String) meal.get("XINGMING"));
        this.updateUser(updateReqVO);

        // 插入会员健康档案数据
        PatientHealthDO patientHealthInsert = new PatientHealthDO();
        patientHealthInsert.setMemberId(patientHealthCreateReqVO.getMemberId());
        patientHealthInsert.setInpatientNo(patientHealthCreateReqVO.getInpatientNo());
        patientHealthInsert.setDepartment(meal.get("DANGQIANKSMC").toString());
        patientHealthInsert.setHeight((String) meal.get("SHENGAO"));
        patientHealthInsert.setWeight((String) meal.get("TIZHONG"));
        patientHealthInsert.setTreatmentArea((String) meal.get("DANGQIANBQMC"));
        if (meal.get("DANGQIANCW")!=null&&((String) meal.get("DANGQIANCW")).contains("-")) {
            patientHealthInsert.setBedNo((String) meal.get("DANGQIANCW"));
        }
        if (meal.get("DANGQIANCW")!=null&&!((String) meal.get("DANGQIANCW")).contains("-")) {
            patientHealthInsert.setBedNo(meal.get("DANGQIANCW").toString() + "-0");
        }
        // TODO 医嘱信息
//        String medicalAdviceId = medicalAdviceDao.getMediaName((String) meal.get("YIZHUMC"));
//        if(StringUtils.isNotEmpty(medicalAdviceId)){
//            patientHealthInsert.setMedicalAdviceId(medicalAdviceId);
//        }else{
//            patientHealthInsert.setMedicalAdviceId("1479712155843063808");
//        }
        if (meal.get("XINGBIE")!=null&&"男".equals(meal.get("XINGBIE").toString())) {
            patientHealthInsert.setSex(1);
        } else {
            patientHealthInsert.setSex(0);
        }
        patientHealthInsert.setAge(Integer.valueOf(String.format("%.0f", meal.get("NIANLING"))));
        patientHealthInsert.setName(memberUserDO.getNickname());
        patientHealthMapper.insert(patientHealthInsert);
        return CommonResult.success("绑定成功！");
    }


    /**
     * @Description:绑定患者信息NoHis
     * @param patientHealthCreateReqVO
     * @Date: 2022/11/23
     * @author: lihongyan
     * @throws
     * @return:cn.iocoder.yudao.framework.common.pojo.CommonResult
     */
    @Override
    public CommonResult bindPatientHealthInfoNoHis(PatientHealthCreateReqVO patientHealthCreateReqVO) {
        // 会员ID必传
        if (Objects.isNull(patientHealthCreateReqVO.getMemberId())){
            CommonResult.error(MEMBER_ID_NOT_EXISTS);
        }
        // 查询该会员是否已绑定健康档案
        QueryWrapper<PatientHealthDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Objects.isNull(patientHealthCreateReqVO.getMemberId()),"member_id", patientHealthCreateReqVO.getMemberId());
        queryWrapper.eq(Objects.isNull(patientHealthCreateReqVO.getSource()), "source",patientHealthCreateReqVO.getSource());
        queryWrapper.eq(Objects.isNull(patientHealthCreateReqVO.getTenantId()), "tenant_id",patientHealthCreateReqVO.getTenantId());
        queryWrapper.eq(Objects.isNull(patientHealthCreateReqVO.getSubjectId()), "subject_id",patientHealthCreateReqVO.getSubjectId());
        queryWrapper.eq("deleted","0");
        PatientHealthDO patientHealthCheck = patientHealthMapper.selectOne(queryWrapper);
        if (patientHealthCheck != null) {
            // 插入会员健康档案数据
            PatientHealthDO patientHealthInsert = new PatientHealthDO();
            patientHealthInsert.setMemberId(patientHealthCreateReqVO.getMemberId());
            patientHealthInsert.setInpatientNo(patientHealthCreateReqVO.getInpatientNo());
            patientHealthInsert.setDepartment(patientHealthCreateReqVO.getDepartment());
            patientHealthInsert.setHeight(patientHealthCreateReqVO.getHeight());
            patientHealthInsert.setWeight(patientHealthCreateReqVO.getWeight());
            patientHealthInsert.setTreatmentArea(patientHealthCreateReqVO.getTreatmentArea());
            patientHealthInsert.setBedNo(patientHealthCreateReqVO.getBedNo());
            patientHealthInsert.setSex(patientHealthCreateReqVO.getSex());
            patientHealthInsert.setAge(patientHealthCreateReqVO.getAge());
            patientHealthInsert.setName(patientHealthCreateReqVO.getName());
            // 医嘱信息
            patientHealthInsert.setMedicalAdviceId(patientHealthCreateReqVO.getMedicalAdviceId());

            patientHealthMapper.insert(patientHealthInsert);
        }else{
            patientHealthService.createPatientHealth(patientHealthCreateReqVO);
        }
        // 查询会员信息并修改姓名
        QueryWrapper<MemberUserDO> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq(Objects.isNull(patientHealthCreateReqVO.getMemberId()),"member_id", patientHealthCreateReqVO.getMemberId());
        userQueryWrapper.eq(Objects.isNull(patientHealthCreateReqVO.getSource()), "source",patientHealthCreateReqVO.getSource());
        userQueryWrapper.eq(Objects.isNull(patientHealthCreateReqVO.getTenantId()), "tenant_id",patientHealthCreateReqVO.getTenantId());
        userQueryWrapper.eq(Objects.isNull(patientHealthCreateReqVO.getSubjectId()), "subject_id",patientHealthCreateReqVO.getSubjectId());
        userQueryWrapper.eq("deleted","0");
        MemberUserDO memberUserDO = userMapper.selectOne(userQueryWrapper);
        MemberUserUpdateReqVO updateReqVO = new MemberUserUpdateReqVO();
        updateReqVO.setId(memberUserDO.getId());
        updateReqVO.setNickname(patientHealthCreateReqVO.getName());
        this.updateUser(updateReqVO);

        return CommonResult.success("绑定成功！");
    }

    @Override
    public CommonResult updateAuditStatus(MemberUserUpdateDetailReqVO updateReqVO) {
        if (Objects.isNull(updateReqVO.getAuditStatus())){
            return CommonResult.error(AUDITSTATUS_NOT_EXISTS);
        }
        // 校验会员是否存在
        this.validateUserExists(updateReqVO.getId());

        // 修改关联表审核状态
        MemberUserDetailUpdateReqVO detailUpdateReqVO = new MemberUserDetailUpdateReqVO();
        detailUpdateReqVO.setId(updateReqVO.getMemberUserDetailId());
        detailUpdateReqVO.setMemberId(updateReqVO.getId());
        detailUpdateReqVO.setAuditStatus(updateReqVO.getAuditStatus());
        // 审核为驳回时，保存驳回原因
        // 审核状态 0-待审核 1-审核通过 2-已驳回 3-已解绑
        if(updateReqVO.getAuditStatus() == 2){
            detailUpdateReqVO.setRemarks(updateReqVO.getRemarks());
        }
        memberUserDetailService.updateUserDetail(detailUpdateReqVO);
        return CommonResult.success("审核成功！");
    }

    @Override
    public CommonResult unbundling(MemberUserUpdateDetailReqVO updateReqVO) {
        if (Objects.isNull(updateReqVO.getAuditStatus())){
            return CommonResult.error(AUDITSTATUS_NOT_EXISTS);
        }
        // 校验会员是否存在
        this.validateUserExists(updateReqVO.getId());

        // 修改关联表审核状态
        MemberUserDetailUpdateReqVO detailUpdateReqVO = new MemberUserDetailUpdateReqVO();
        detailUpdateReqVO.setId(updateReqVO.getMemberUserDetailId());
        detailUpdateReqVO.setMemberId(updateReqVO.getId());
        detailUpdateReqVO.setAuditStatus(updateReqVO.getAuditStatus());
        memberUserDetailService.updateUserDetail(detailUpdateReqVO);
        return CommonResult.success("解绑成功！");
    }

    @Override
    public CommonResult updateMemberType(MemberUserUpdateDetailReqVO updateReqVO) {
        if (Objects.isNull(updateReqVO.getMemberType())){
            return CommonResult.error(MEMBERTYPE_NOT_EXISTS);
        }
        // 校验会员是否存在
        this.validateUserExists(updateReqVO.getId());

        // 修改关联表会员类型
        MemberUserDetailUpdateReqVO detailUpdateReqVO = new MemberUserDetailUpdateReqVO();
        detailUpdateReqVO.setId(updateReqVO.getMemberUserDetailId());
        detailUpdateReqVO.setMemberId(updateReqVO.getId());
        detailUpdateReqVO.setMemberType(updateReqVO.getMemberType());
        memberUserDetailService.updateUserDetail(detailUpdateReqVO);
        return CommonResult.success("修改会员类型！");
    }

    @Override
    public MemberUserRespVO getUserDetail(Long id) {
        return null;
    }
}
