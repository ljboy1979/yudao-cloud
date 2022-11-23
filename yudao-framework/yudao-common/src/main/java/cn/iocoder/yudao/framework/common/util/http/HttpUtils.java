package cn.iocoder.yudao.framework.common.util.http;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.map.TableMap;
import cn.hutool.core.net.url.UrlBuilder;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * HTTP 工具类
 *
 * @author 芋道源码
 */
public class HttpUtils {

    @SuppressWarnings("unchecked")
    public static String replaceUrlQuery(String url, String key, String value) {
        UrlBuilder builder = UrlBuilder.of(url, Charset.defaultCharset());
        // 先移除
        TableMap<CharSequence, CharSequence> query = (TableMap<CharSequence, CharSequence>)
                ReflectUtil.getFieldValue(builder.getQuery(), "query");
        query.remove(key);
        // 后添加
        builder.addQuery(key, value);
        return builder.build();
    }

    private String append(String base, Map<String, ?> query, boolean fragment) {
        return append(base, query, null, fragment);
    }

    /**
     * 拼接 URL
     *
     * copy from Spring Security OAuth2 的 AuthorizationEndpoint 类的 append 方法
     *
     * @param base 基础 URL
     * @param query 查询参数
     * @param keys query 的 key，对应的原本的 key 的映射。例如说 query 里有个 key 是 xx，实际它的 key 是 extra_xx，则通过 keys 里添加这个映射
     * @param fragment URL 的 fragment，即拼接到 # 中
     * @return 拼接后的 URL
     */
    public static String append(String base, Map<String, ?> query, Map<String, String> keys, boolean fragment) {
        UriComponentsBuilder template = UriComponentsBuilder.newInstance();
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(base);
        URI redirectUri;
        try {
            // assume it's encoded to start with (if it came in over the wire)
            redirectUri = builder.build(true).toUri();
        } catch (Exception e) {
            // ... but allow client registrations to contain hard-coded non-encoded values
            redirectUri = builder.build().toUri();
            builder = UriComponentsBuilder.fromUri(redirectUri);
        }
        template.scheme(redirectUri.getScheme()).port(redirectUri.getPort()).host(redirectUri.getHost())
                .userInfo(redirectUri.getUserInfo()).path(redirectUri.getPath());

        if (fragment) {
            StringBuilder values = new StringBuilder();
            if (redirectUri.getFragment() != null) {
                String append = redirectUri.getFragment();
                values.append(append);
            }
            for (String key : query.keySet()) {
                if (values.length() > 0) {
                    values.append("&");
                }
                String name = key;
                if (keys != null && keys.containsKey(key)) {
                    name = keys.get(key);
                }
                values.append(name).append("={").append(key).append("}");
            }
            if (values.length() > 0) {
                template.fragment(values.toString());
            }
            UriComponents encoded = template.build().expand(query).encode();
            builder.fragment(encoded.getFragment());
        } else {
            for (String key : query.keySet()) {
                String name = key;
                if (keys != null && keys.containsKey(key)) {
                    name = keys.get(key);
                }
                template.queryParam(name, "{" + key + "}");
            }
            template.fragment(redirectUri.getFragment());
            UriComponents encoded = template.build().expand(query).encode();
            builder.query(encoded.getQuery());
        }
        return builder.build().toUriString();
    }

    public static String[] obtainBasicAuthorization(HttpServletRequest request) {
        String clientId;
        String clientSecret;
        // 先从 Header 中获取
        String authorization = request.getHeader("Authorization");
        authorization = StrUtil.subAfter(authorization, "Basic ", true);
        if (StringUtils.hasText(authorization)) {
            authorization = Base64.decodeStr(authorization);
            clientId = StrUtil.subBefore(authorization, ":", false);
            clientSecret = StrUtil.subAfter(authorization, ":", false);
        // 再从 Param 中获取
        } else {
            clientId = request.getParameter("client_id");
            clientSecret = request.getParameter("client_secret");
        }

        // 如果两者非空，则返回
        if (StrUtil.isNotEmpty(clientId) && StrUtil.isNotEmpty(clientSecret)) {
            return new String[]{clientId, clientSecret};
        }
        return null;
    }

    public static String getInvokePOSTMethod(String uri){
        HttpURLConnection connection = null;
        OutputStreamWriter osw = null;
        InputStreamReader isr = null;
        Long start = System.currentTimeMillis();
        try {
            //创建URL访问连接
            URL url = new URL(uri);
            connection = (HttpURLConnection) url.openConnection();
            //数据传输方式
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(10000);
            connection.connect();

            isr = new InputStreamReader(connection.getInputStream(), "UTF-8");

            int c = -1;
            StringBuilder sb = new StringBuilder();
            while ((c = isr.read()) >= 0) {
                sb.append((char) c);
            }

            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                if (null != osw)
                    osw.close();

                if (null != isr)
                    isr.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            connection.disconnect();
            Long end = System.currentTimeMillis();
        }
    }

}
