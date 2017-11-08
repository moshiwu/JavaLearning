package com.company;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jdk.internal.dynalink.support.NameCodec.encode;

/**
 * Created by moqiaowen on 2017/5/17.
 */
public class Http_Request_and_Response {

    static HttpClient client = HttpClients.createDefault();


    static Runnable mission1 = new Runnable() {
        @Override
        public void run() {
            try {
                System.out.println("get start");
                HttpClient_get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    static Runnable mission2 = new Runnable() {
        @Override
        public void run() {
            try {
                System.out.println("post start");
                HttpClient_post();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) throws Exception {


//        http_get();

        //使用Apache的第三方
        //网络请求不能在主线程运行
        new Thread(mission1).start();

        new Thread(mission2).start();

    }



    public static void HttpClient_get() throws Exception {

        HttpGet get = new HttpGet(getTestUrlString());

        HttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);

        System.out.println("result : " + result);

    }

    public static void HttpClient_post() throws Exception {

        List<BasicNameValuePair> parameters = new ArrayList<>();


        String appKey = "481f248f15472dfa";
        String query = "你好 哈哈";
        String salt = String.valueOf(System.currentTimeMillis());
        String from = "zh_CHS";
        String to = "en";
        String sign = md5(appKey + query + salt + "H9UGfYCVQyu95UOBHW1oC78gKREUSxka");

        HttpPost post = new HttpPost("https://openapi.youdao.com/api");

//        new UrlEncodedFormEntity()
        parameters.add(new BasicNameValuePair("appKey", appKey));
        parameters.add(new BasicNameValuePair("salt", salt));
        parameters.add(new BasicNameValuePair("sign", sign));
        parameters.add(new BasicNameValuePair("to", to));
        parameters.add(new BasicNameValuePair("from", from));
        parameters.add(new BasicNameValuePair("q", query));

        post.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8"));

        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity, "UTF-8");
        System.out.println(result);
        System.out.println("123");

        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(result);

        System.out.println("json : " + object);

    }


    public static String getTestUrlString() throws Exception {
        String appKey = "481f248f15472dfa";
        String query = "你好 哈哈";
        String salt = String.valueOf(System.currentTimeMillis());
        String from = "zh_CHS";
        String to = "en";
        String sign = md5(appKey + query + salt + "H9UGfYCVQyu95UOBHW1oC78gKREUSxka");


        Map<String, String> params = new HashMap<String, String>();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);
        params.put("sign", sign);
        params.put("salt", salt);
        params.put("appKey", appKey);


        String urlString = getUrlWithQueryString("https://openapi.youdao.com/api", params);

        return urlString;
    }

    public static void http_get() throws Exception {


        String urlString = getTestUrlString();

        System.out.println(urlString);

        URL url = new URL(urlString);

        URLConnection connect = url.openConnection();


        InputStream is = connect.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String line;
        StringBuilder builder = new StringBuilder();

        while ((line = br.readLine()) != null) {
            builder.append(line);
        }

        br.close();
        isr.close();
        is.close();

        System.out.println(builder);
    }

    /**
     * 根据api地址和参数生成请求URL
     *
     * @param url
     * @param params
     * @return
     */
    public static String getUrlWithQueryString(String url, Map<String, String> params) throws Exception {
        if (params == null) {
            return url;
        }

        StringBuilder builder = new StringBuilder(url);
        if (url.contains("?")) {
            builder.append("&");
        } else {
            builder.append("?");
        }

        int i = 0;
        for (String key : params.keySet()) {
            String value = params.get(key);

            value = URLEncoder.encode(value, "UTF-8");
            value = value.replaceAll("\\+", "%20");
            if (value == null) { // 过滤空的key
                continue;
            }

            if (i != 0) {
                builder.append('&');
            }

            builder.append(key);
            builder.append('=');
            builder.append(encode(value));

            i++;
        }

        return builder.toString();
    }


    /**
     * 生成32位MD5摘要
     *
     * @param string
     * @return
     */
    public static String md5(String string) {
        if (string == null) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        byte[] btInput = string.getBytes();
        try {
            /** 获得MD5摘要算法的 MessageDigest 对象 */
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            /** 使用指定的字节更新摘要 */
            mdInst.update(btInput);
            /** 获得密文 */
            byte[] md = mdInst.digest();
            /** 把密文转换成十六进制的字符串形式 */
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}


