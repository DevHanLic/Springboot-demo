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
        HttpEntity entity = new StringEntity("AQBHUxJ2r/+li4M5xATWxnW3xy+C/N2sfVJOSSZSe4Fs6BlzHQEmNtRbxXNSzKXQxdALHnuOZBiLmjWyKd4aOuTvUv+RfTQ9mmanLA5WO4DfqlAe0Ou3y8+jTht7HcwyDqCugvur4JgMl7UhN/t7q+fwfKTELeb8itRuEmAH1ZgcgAUkr7bIYlT3tniVwrXgNSJH/xXZ1g8DIiUnhuOa6z9e5W4qrJiKTUh9QRtj7ieZ6wmy7E7Jdn7Vn3t2x7QSSiuIN7kOz+F+zFs5Anz9o89peIbOPDTyz95nEy0Luwr/PlPn8w2AdXIEf6sEff2iCCsp9t/Z6fsyUV6jP1LEMO0iHZVjUEfRLLsfVRPKx0zwSoKiaZVO2nXhXZMcfLtTA+0=", Consts.UTF_8);
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}
