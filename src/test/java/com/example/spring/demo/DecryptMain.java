package com.example.spring.demo;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author han_lic
 * @date 2020/11/6 12:50
 */
public class DecryptMain {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        // 发送post请求
        HttpPost post = new HttpPost("http://localhost:3344/decrypt");

        // 设置请求的参数，对2cdf324e7d8c6271d883a7a9bdcac532d027141545f1fed273f8c2b803bc3e9d进行解密，编码格式为UTF-8
        HttpEntity entity = new StringEntity("9be085d3a74e0699d5801477b1375733db13f5a975210cf8959d707924c6bb85", Consts.UTF_8);
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}
