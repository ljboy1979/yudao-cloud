package cn.iocoder.yudao.framework.common.util.wechat;


import cn.iocoder.yudao.framework.common.util.http.HttpUtils;

/**
 * @author liyu
 * @Description: 微信接口工具类
 */
public class WechatUtil {

	private static char[] charArr = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
		'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};


	// Url常量
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";//获取access_token
	public static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";//自定义菜单创建接口
	public static final String SEND_TEMPLATE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";//发送模板消息
	public static final String JSAPI_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	public static final String GET_UNIONID_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	//小程序模板消息接口
	public static final String APP_SEND_TEMPLATE_URL = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";

	//网页授权获取用户基本信息
	public static final String OAUTH2_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";//第一步：用户同意授权，获取code
	public static final String OAUTH2_GET_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";//第二步：通过code换取网页授权access_token
	public static final String OAUTH2_GET_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";//第四步：拉取用户信息(需scope为 snsapi_userinfo)
	//	//素材管理
	public static final String MATERIAL_COUNT_URL = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";//获取素材总数
	public static final String BATCHGET_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";//获取素材列表
	public static final String GET_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";//获取素材列表

	//小程序客服信息发送消息
	public static final String MINIPROGRAM_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";//发送小程序客服消息给用户
	// 拉取用户信息授权类型
	public static final String SCOPE_OPENID = "snsapi_base";
	public static final String SCOPE_USERINFO = "snsapi_userinfo";

	// 自定义菜单类型
	public static final String MENU_TYPE_CLICK = "click";
	public static final String MENU_TYPE_VIEW = "view";
	public static final String MENU_TYPE_MINIPROGRAM = "miniprogram";

	// 按钮EventKey
	public static final String BUTTON_CUSTOMER_SERVICE = "customer_service";

	public static String REDIS_IP;//
	public static String REDIS_PASSWD;//
	public static String APPLETAPPID;//小程序相关
	public static String APPLETAPPSECRET;
	public static String FLAG;//是否获取access_token标识
	//临时菜单

//	登录凭证校验。通过 wx.login 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程
	public static final String OAUTH2_GET_CODE2_SESSION_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
//	授权类型，此处只需填写 authorization_code
	public static final String GRANT_TYPE = "authorization_code";

//	/**
//	 * 加载配置文件内容
//	 */
//	public static void wireProperties(Properties properties) {
//		FLAG = properties.getProperty("FLAG");
//		logger.info("FLAG --> " + FLAG);
//	}
//
//	/**
//	 * 生成随即字符串
//	 */
//	public static String createnNonce_str(){
//		Random r = new Random();
//		StringBuilder sb = new StringBuilder();
//		int length = charArr.length;
//		for (int i = 0; i < 16; i++){
//			sb.append(charArr[r.nextInt(length - 1)]);
//		}
//		return sb.toString();
//	}
//
//	/**
//	 * 拼接signature字符串
//	 * @param
//	 * @param noncestr
//	 * @param timestamp
//	 * @param url
//	 * @return
//	 */
//	public static String getSignature(String noncestr, long timestamp, String url,String ticket){
//		StringBuilder sb = new StringBuilder();
//		sb.append("jsapi_ticket=").append(ticket);
//		sb.append("&").append("noncestr=").append(noncestr);
//		sb.append("&").append("timestamp=").append(timestamp);
//		sb.append("&").append("url=").append(url.indexOf("#") >= 0 ? url.substring(0, url.indexOf("#")) : url);
//		return sb.toString();
//	}
//
//	/**
//	 * 获取接口调用公众号凭证access_token
//	 *
//	 * @return
//	 */
//	public static AccessToken getToken(String appId, String appSecret) {
//		AccessToken token = new AccessToken();
//		String urlStr = ACCESS_TOKEN_URL.replace("APPID", appId).replace(
//				"APPSECRET", appSecret);
//		logger.info("公众号获取access_token 地址 -->  " + urlStr);
//		String respStr = HttpUtil.getInvoke(urlStr);
//		logger.info("公众号获取access_token 接口返回" + respStr);
//		if (null != respStr) {
//			JSONObject json = JSONObject.fromObject(respStr);
//			token.setAccessToken(json.getString("access_token"));
//			token.setExpiresIn(Integer.parseInt(json.getString("expires_in")));
//		}
//
//		return token;
//	}
//
//    /**
//     * 根据公众号token获取JSAPI_TICKET
//	 * @param accessToken
//     * @return
//     */
//	public static JsApiTicket getJsApiTicket(String accessToken){
//		String urlStr = JSAPI_TICKET_URL.replace("ACCESS_TOKEN", accessToken);
//		String respStr = HttpUtils.getInvoke(urlStr);
//		logger.info("微信api_ticket接口返回 -->" + respStr);
//		JsApiTicket jsApiTicket = new JsApiTicket();
//		if (null != respStr) {
//			JSONObject json = JSONObject.fromObject(respStr);
//			if(json.getInt("errcode") == 0){
//				jsApiTicket.setTicket(json.getString("ticket"));
//				jsApiTicket.setExpiresIn(json.getInt("expires_in"));
//			}
//		}
//		return jsApiTicket;
//	}
//	/**
//	 * 获取接口调用小程序凭证access_token
//	 *
//	 * @return
//	 */
//	public static AccessToken getAppletToken(String AppId, String AppSecret) {
//		AccessToken token = new AccessToken();
//		String urlStr = ACCESS_TOKEN_URL.replace("APPID", AppId).replace(
//				"APPSECRET", AppSecret);
//		logger.info("小程序 获取access_token 地址 -->  " + urlStr);
//		String respStr = HttpUtil.getInvoke(urlStr);
//		logger.info("小程序 获取access_token 接口返回" + respStr);
//		if (null != respStr) {
//			JSONObject json = JSONObject.fromObject(respStr);
//			token.setAccessToken(json.getString("access_token"));
//			token.setExpiresIn(Integer.parseInt(json.getString("expires_in")));
//		}
//		return token;
//	}
//
//	/**
//	 * OTH2获取用户openId
//	 * @param code
//	 * @return
//	 */
//	public static JSONObject oth2GetOpenId(String code,String appId,String appsecret){
//		String result = HttpUtil.getInvoke(WechatUtil.OAUTH2_GET_TOKEN_URL.replace("APPID", appId).replace("SECRET", appsecret).replace("CODE", code));
//		JSONObject json = JSONObject.fromObject(result);
//		return json;
//	}
//
//	/**
//	 * OTH2获取用户详细信息
//	 * @param openId
//	 * @param accessToken
//	 * @return
//	 */
//	public static JSONObject oth2GetUserInfo(String openId, String accessToken){
//		String result = HttpUtil.getInvoke(WechatUtil.OAUTH2_GET_USERINFO_URL.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId));
//		JSONObject json = JSONObject.fromObject(result);
//		return json;
//	}
//
	/**
	 * 登录凭证校验。通过 wx.login 接口获得临时登录凭证 code 调用此接口完成登录流程
	 * @param code
	 * @return
	 */
	public static String oth2GetJscode2Session(String code,String appId,String appsecret){
		String result = HttpUtils.getInvokePOSTMethod(WechatUtil.OAUTH2_GET_CODE2_SESSION_URL.replace("APPID", appId).replace("SECRET", appsecret).replace("JSCODE",code));
		if (result != null){
			return result;
		}else {
			return null;
		}
	}
//
//    /**
//     * 生成签名
//	 * @param url
//     * @return
//     */
//	public static String createSignature(String url,String ticket){
//		long timestamp = System.currentTimeMillis() / 1000;
//		String nonceStr= WechatUtil.createnNonce_str();
//		String signature= ValidateUtil.encodePassword(WechatUtil.getSignature(nonceStr,timestamp,url,ticket),"SHA");
//		return signature;
//	}


}
