package cn.acsm.module.member.signin.service.config;

import cn.acsm.module.member.signin.api.wechat.wechat.dto.WeChatReqDTO;
import cn.acsm.module.member.signin.api.wechat.wechat.dto.WeChatRespDTO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthConfigInfoCreateReqVO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthConfigInfoExportReqVO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthConfigInfoPageReqVO;
import cn.acsm.module.member.signin.controller.admin.config.vo.AuthConfigInfoUpdateReqVO;
import cn.acsm.module.member.signin.convert.config.AuthConfigInfoConvert;
import cn.acsm.module.member.signin.dal.dataobject.config.AuthConfigInfoDO;
import cn.acsm.module.member.signin.dal.mysql.config.AuthConfigInfoMapper;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.aes.AesCbcUtil;
import cn.iocoder.yudao.framework.common.util.wechat.WechatUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.acsm.module.member.signin.enums.ErrorCodeConstants.*;

/**
 * 会员登录授权配置信息 Service 实现类
 *
 * @author lihongyan
 */
@Service
@Validated
public class AuthConfigInfoServiceImpl implements AuthConfigInfoService {

    @Resource
    private AuthConfigInfoMapper authConfigInfoMapper;

    @Override
    public Long createAuthConfigInfo(AuthConfigInfoCreateReqVO createReqVO) {
        // 插入
        AuthConfigInfoDO authConfigInfo = AuthConfigInfoConvert.INSTANCE.convert(createReqVO);
        authConfigInfoMapper.insert(authConfigInfo);
        // 返回
        return authConfigInfo.getId();
    }

    @Override
    public void updateAuthConfigInfo(AuthConfigInfoUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateAuthConfigInfoExists(updateReqVO.getId());
        // 更新
        AuthConfigInfoDO updateObj = AuthConfigInfoConvert.INSTANCE.convert(updateReqVO);
        authConfigInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteAuthConfigInfo(Long id) {
        // 校验存在
        this.validateAuthConfigInfoExists(id);
        // 删除
        authConfigInfoMapper.deleteById(id);
    }

    private void validateAuthConfigInfoExists(Long id) {
        if (authConfigInfoMapper.selectById(id) == null) {
            throw exception(AUTH_CONFIG_INFO_NOT_EXISTS);
        }
    }

    @Override
    public AuthConfigInfoDO getAuthConfigInfo(Long id) {
        return authConfigInfoMapper.selectById(id);
    }

    @Override
    public List<AuthConfigInfoDO> getAuthConfigInfoList(Collection<Long> ids) {
        return authConfigInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<AuthConfigInfoDO> getAuthConfigInfoPage(AuthConfigInfoPageReqVO pageReqVO) {
        return authConfigInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<AuthConfigInfoDO> getAuthConfigInfoList(AuthConfigInfoExportReqVO exportReqVO) {
        return authConfigInfoMapper.selectList(exportReqVO);
    }

    /**
     * @Description:获取用户openId和手机号
     * @param reqDTO
     * @Date: 2022/11/17
     * @author: lihongyan
     * @throws
     * @return:cn.iocoder.yudao.framework.common.pojo.CommonResult
     */
    public CommonResult<WeChatRespDTO> getOpenIdAndPhone(WeChatReqDTO reqDTO){
        WeChatRespDTO respDTO = new WeChatRespDTO();
        if(Objects.isNull(reqDTO.getSource())){
            return CommonResult.error(SOURCE_NOT_EXISTS);
        }
        // 获取微信配置信息
        AuthConfigInfoDO authConfigInfoDO = new AuthConfigInfoDO();
        authConfigInfoDO.setSource(reqDTO.getSource());
        authConfigInfoDO.setAppletFlag(reqDTO.getAppletFlag());
        List<AuthConfigInfoDO> weixinDeployInfoDOList = authConfigInfoMapper.selectListBySource(authConfigInfoDO);
        if (weixinDeployInfoDOList.size() > 0){
            AuthConfigInfoDO authConfigInfo = new AuthConfigInfoDO();
            authConfigInfo = weixinDeployInfoDOList.get(0);
            String returnStr = WechatUtil.oth2GetJscode2Session(reqDTO.getCode(),authConfigInfo.getAppId(),authConfigInfo.getAppSecret());
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
                String result = AesCbcUtil.decrypt(reqDTO.getEncryptedData(), json.getString("session_key"), reqDTO.getIv(), "UTF-8");
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
            respDTO.setPhone(phone);
            respDTO.setOpenId(openId);

        }else{
            respDTO.setPhone("18888888888");
            respDTO.setOpenId("asdqwfgasfa65481df");
            return  CommonResult.success(respDTO);
//            return CommonResult.error(WECHAT_CONFIGURATION_NOT_EXISTS);
        }
        return  CommonResult.success(respDTO);
    }

}
