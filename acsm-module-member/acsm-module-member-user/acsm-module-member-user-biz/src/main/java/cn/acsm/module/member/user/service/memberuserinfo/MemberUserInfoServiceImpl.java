package cn.acsm.module.member.user.service.memberuserinfo;

import cn.acsm.module.member.user.controller.admin.memberuserinfo.vo.MemberUserInfoCreateReqVO;
import cn.acsm.module.member.user.controller.admin.memberuserinfo.vo.MemberUserInfoExportReqVO;
import cn.acsm.module.member.user.controller.admin.memberuserinfo.vo.MemberUserInfoPageReqVO;
import cn.acsm.module.member.user.controller.admin.memberuserinfo.vo.MemberUserInfoUpdateReqVO;
import cn.acsm.module.member.user.controller.app.memberuserinfo.vo.AppMemberUserInfoRegisteredVO;
import cn.acsm.module.member.user.convert.memberuserinfo.MemberUserInfoConvert;
import cn.acsm.module.member.user.dal.dataobject.memberuserinfo.MemberUserInfoDO;
import cn.acsm.module.member.user.dal.dataobject.wechat.WeixinDeployInfoDO;
import cn.acsm.module.member.user.dal.mysql.memberuserinfo.MemberUserInfoMapper;
import cn.acsm.module.member.user.dal.mysql.wechat.WeixinLoginInfoMapper;
import cn.acsm.module.member.user.service.member.MemberUserService;
import cn.acsm.module.member.user.service.wechat.WeixinDeployInfoService;
import cn.acsm.module.member.user.service.wechat.WeixinLoginInfoService;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.aes.AesCbcUtil;
import cn.iocoder.yudao.framework.common.util.wechat.WechatUtil;
import cn.iocoder.yudao.module.system.api.oauth2.OAuth2TokenApi;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.acsm.module.member.user.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;


/**
 * 用户基本信息 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class MemberUserInfoServiceImpl implements MemberUserInfoService {

    @Resource
    private MemberUserInfoMapper userInfoMapper;

    @Resource
    private WeixinDeployInfoService weixinDeployInfoService;

    @Resource
    private WeixinLoginInfoService weixinLoginInfoService;

    @Resource
    private MemberUserService memberUserService;

    @Resource
    private WeixinLoginInfoMapper weixinLoginInfoMapper;

    @Resource
    private OAuth2TokenApi oauth2TokenApi;


    @Override
    public Long createUserInfo(MemberUserInfoCreateReqVO createReqVO) {
        // 插入
        MemberUserInfoDO userInfo = MemberUserInfoConvert.INSTANCE.convert(createReqVO);
        userInfoMapper.insert(userInfo);
        // 返回
        return userInfo.getId();
    }

    @Override
    public void updateUserInfo(MemberUserInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateUserInfoExists(updateReqVO.getId());
        // 更新
        MemberUserInfoDO updateObj = MemberUserInfoConvert.INSTANCE.convert(updateReqVO);
        userInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteUserInfo(Long id) {
        // 校验存在
        this.validateUserInfoExists(id);
        // 删除
        userInfoMapper.deleteById(id);
    }

    private void validateUserInfoExists(Long id) {
        if (userInfoMapper.selectById(id) == null) {
            throw exception(USER_INFO_NOT_EXISTS);
        }
    }

    @Override
    public MemberUserInfoDO getUserInfo(Long id) {
        return userInfoMapper.selectById(id);
    }

    @Override
    public List<MemberUserInfoDO> getUserInfoList(Collection<Long> ids) {
        return userInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MemberUserInfoDO> getUserInfoPage(MemberUserInfoPageReqVO pageReqVO) {
        return userInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MemberUserInfoDO> getUserInfoList(MemberUserInfoExportReqVO exportReqVO) {
        return userInfoMapper.selectList(exportReqVO);
    }

    /**
     * @Description:获取用户openId和手机号
     * @param registeredVO
     * @Date: 2022/11/8
     * @author: lihongyan
     * @throws
     * @return:cn.iocoder.yudao.framework.common.pojo.CommonResult
     */
    public CommonResult getOpenIdAndPhone(AppMemberUserInfoRegisteredVO registeredVO){
        JSONObject resultJson = new JSONObject();
        if(!StringUtils.isNotEmpty(registeredVO.getTenantId())){
            return CommonResult.error(TENANTID_NOT_EXISTS);
        }
        // 获取微信配置信息
        WeixinDeployInfoDO weixinDeployInfoDO = new WeixinDeployInfoDO();
        weixinDeployInfoDO.setTenantId(Long.valueOf(registeredVO.getTenantId()));
        weixinDeployInfoDO.setAppletFlag(registeredVO.getAppletFlag());
        List<WeixinDeployInfoDO> weixinDeployInfoDOList = weixinDeployInfoService.selectListByTenantId(weixinDeployInfoDO);
        if (weixinDeployInfoDOList.size() > 0){
            WeixinDeployInfoDO weixinDeployInfo = new WeixinDeployInfoDO();
            weixinDeployInfo = weixinDeployInfoDOList.get(0);
            String returnStr = WechatUtil.oth2GetJscode2Session(registeredVO.getCode(),weixinDeployInfo.getAppid(),weixinDeployInfo.getAppsecret());
            JSONObject json = JSONObject.parseObject(returnStr);

            String openId = "";
            if (null != json && json.containsKey("session_key") && json.containsKey("openid")) {
                openId = json.getString("openid");
            }
            if (StringUtils.isEmpty(openId)){
                return CommonResult.error(201,"授权失败,未获取openid");
            }
            String phone = "";
            try {
                String result = AesCbcUtil.decrypt(registeredVO.getEncryptedData(), json.getString("session_key"), registeredVO.getIv(), "UTF-8");
                if (null != result && result.length() > 0) {
                    System.out.println("解密session_key : "+result);
                    JSONObject userInfoJSON = JSONObject.parseObject(result);
                    if(userInfoJSON.containsKey("phoneNumber")){
                        phone = userInfoJSON.get("phoneNumber").toString();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return CommonResult.error(201,"解密失败");
            }

            if (StringUtils.isEmpty(phone)){
                return CommonResult.error(201,"未获取到手机号！！");
            }
            registeredVO.setPhone(phone);
            registeredVO.setOpenId(openId);
            //获取登录信息
//            JSONObject jsonObject = this.registOrLoginByPhoneAndTenantId(phone,registeredVO.getTenantId());

        }else{
            return CommonResult.error(WECHAT_CONFIGURATION_NOT_EXISTS);
        }
        return  null;
    }

    @Override
    public CommonResult registOrLoginByPhoneAndTenantId(AppMemberUserInfoRegisteredVO registeredVO) {
        return null;
    }

//    /**
//     * @Description:根据手机号和租户编号进行用户注册或登录
//     * @param phone
//     * @param tenantId
//     * @Date: 2022/11/9
//     * @author: lihongyan
//     * @throws
//     * @return:com.alibaba.fastjson.JSONObject
//     */
//    public CommonResult registOrLoginByPhoneAndTenantId(AppMemberUserInfoRegisteredVO registeredVO) {
//          this.getOpenIdAndPhone(registeredVO);
//        MemberUserExportReqVO reqVO = new MemberUserExportReqVO();
//        reqVO.setMobile(phone);
//        reqVO.setTenantId(tenantId);
//        MemberUserDO memberUser= memberUserService.getMemberUserByPhoneAndTenantId(reqVO);
//        if (memberUser != null){
//
//        }
//
//        String returnCode = jsonObject.get("code")+"" ;
//        if (!"0".equals(returnCode)){
//            return  CommonResult.error(500,"登录失败");
//        }
//        JSONObject data = jsonObject.getJSONObject("data");
//        JSONObject loginInfo = data.getJSONObject("loginInfo");
//        System.out.println("用户登录信息"+loginInfo);
//        WeixinLoginInfoDO wixinLoginInfo = weixinLoginInfoMapper.selectInfoBySystemUserId(loginInfo.getString("userId"));
//        if (wixinLoginInfo==null){
//            wixinLoginInfo = new WeixinLoginInfoDO();
//            wixinLoginInfo.setOpenid(openId);
//            wixinLoginInfo.setSystemUserId(loginInfo.getString("userId"));
//            wixinLoginInfo.setPhone(phone);
//            wixinLoginInfo.setType("1");
//            wixinLoginInfo.setTenantId(Long.valueOf(registeredVO.getTenantId()));
//            weixinLoginInfoMapper.insert(wixinLoginInfo);
//        }else{
//            wixinLoginInfo.setOpenid(openId);
//            weixinLoginInfoMapper.updateById(wixinLoginInfo);
//        }
//        data.put("openId",openId);
//
//        // 创建 Token 令牌，记录登录日志
////        return createTokenAfterLoginSuccess(user, user.getMobile(), LoginLogTypeEnum.LOGIN_SOCIAL);
//        return null;
//    }

}
