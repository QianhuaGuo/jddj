package com.example.qianhua.jddc;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;
import o2o.openplatform.sdk.dto.WebRequestDTO;
import o2o.openplatform.sdk.util.HttpUtil;
import o2o.openplatform.sdk.util.SignUtils;
import okhttp3.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class JddjClientManager extends TestCase {
    public static final MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
    public void testSdk() throws Exception{

        String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(dateTimeFormat);
        Date now = new Date();


        //应用授权信息
        String appkey = "251d559d8f8b4b7aba5d4cc5e805226d";
        String appSecret = "a2dc50cd252b4b718496e1c74d4f02fa";
        String token = "fc1f371a-ca3f-47ad-8cf2-284f65fdc3e3";
        String format = "json";
        String v = "1.0";
        String timestamp = sdf.format(now);

//        List<String> param = new ArrayList<>();
//        param.add("id");
//        param.add("pid");
//        param.add("shopCategoryName");
//        param.add("shopCategoryLevel");
//        param.add("sort");

        Map<String,Object> param = new HashMap<>();
        param.put("categoryId",647L);

        String jd_param_json = JSONObject.toJSONString(param);
//        String url = "https://openapi.jddj.com/djapi/pms/queryCategoriesByOrgCode";
        String url = "https://openapi.jddj.com/djapi/pms/getSkuCategoryAttrByCategoryId";

        //计算签名实体
        WebRequestDTO webRequestDTO = new WebRequestDTO();
        webRequestDTO.setApp_key(appkey);
        webRequestDTO.setFormat(format);
        webRequestDTO.setJd_param_json(jd_param_json);
        webRequestDTO.setTimestamp(timestamp);
        webRequestDTO.setV(v);

        String sign = SignUtils.getSignByMD5(webRequestDTO, appSecret);
        System.out.println("md5 sign:" + sign);

        //请求参数实体
        Map<String,Object> params = new HashMap<>();
        params.put("token",token);
        params.put("app_key",appkey);
        params.put("timestamp",timestamp);
        params.put("sign",sign);
        params.put("format",format);
        params.put("v",v);
        params.put("jd_param_json",jd_param_json);

//        String result = HttpUtil.sendSimplePostRequest(url, params);
//        System.out.println(result);
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType,JSONObject.toJSONString(params));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        String string = response.body().string();
        System.out.println("result:"+response);
        assertTrue(true);
    }
}
