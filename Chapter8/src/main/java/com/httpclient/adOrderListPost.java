package com.httpclient;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class adOrderListPost {
    public static void main(String[] args) {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 参数
        StringBuffer params = new StringBuffer();
        //try {
            // 字符数据最好encoding以下;这样一来，某些特殊字符才能传过去(如:某人的名字就是“&”,不encoding的话,传不过去)
            //params.append("platform=iphone" + URLEncoder.encode("&", "utf-8"));
            //params.append("&");
            params.append("page=1");
            params.append("&");
            params.append("rows=10");
        //} catch (UnsupportedEncodingException e1) {
            //e1.printStackTrace();
       // }

        // 创建Post请求
        HttpPost httpPost = new HttpPost("http://uat-adminwow.rr.tv/adOrder/adOrderList" + "?" + params);

        // 设置ContentType(注:如果只是传普通参数的话,ContentType不一定非要用application/json)
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        httpPost.setHeader("Cookie","Hm_lvt_d26b601003e5eb802e089dd9c0c41e35=1553514219,1553832571; Hm_lpvt_d26b601003e5eb802e089dd9c0c41e35=1555417320; JSESSIONID=58F8802DC30CA48FE00BCDD946EB78EC");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
            String json = EntityUtils.toString(responseEntity);
            JSONObject obj = JSONObject.parseObject(json);
            String r = obj.getString("id");
            System.out.println(r);

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }


}
