package com.weloe.httpclient;

import com.sun.javafx.fxml.builder.URLBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class TestHttpClient {
    public static void main(String[] args) throws IOException, URISyntaxException {
        //testGetNoParams();
        testPost();
    }

    public static void testPost() throws IOException, URISyntaxException {
        HttpClient client = HttpClients.createDefault();
        //无参数Post请求
        HttpPost post = new HttpPost("http://localhost/test");
        HttpResponse response=client.execute(post);
        System.out.println(EntityUtils.toString(response.getEntity(),"UTF-8"));

        //有参数的Post请求
        //请求头传递，和Get请求参数的方式
        URIBuilder builder = new URIBuilder("http://localhost/params");
        builder.addParameter("name","post");
        builder.addParameter("password","postPassword");
        HttpResponse httpResponse = client.execute(new HttpPost(builder.build()));
        System.out.println(EntityUtils.toString(httpResponse.getEntity(),"UTF-8"));

        //请求体传递参数
        HttpPost bodyParamsPost = new HttpPost("http://localhost/params");
        //定义请求协议体，设置请求参数，使用请求传递参数的时候，需要定义请求体格式
        //使用URIBuilder构建的URI对象，就是请求体传递参数的
        HttpEntity entity = new StringEntity("");
        bodyParamsPost.setEntity(entity);
        System.out.println(EntityUtils.toString(client.execute(bodyParamsPost).getEntity(),"UTF8"));
    }


    public static void testGetParams() throws IOException, URISyntaxException {
        HttpClient client = HttpClients.createDefault();
        //基于Builder构建请求地址
        URIBuilder builder = new URIBuilder("http://localhost/params");
        //基于单参数传递，构建请求
        /*builder.addParameter("name","www");
        builder.addParameter("password","admin123");
        URI uri = builder.build();*/
        //
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("name","www"));
        nvps.add(new BasicNameValuePair("password","admin123"));

        builder.addParameters(nvps);
        URI uri = builder.build();

        String result = EntityUtils.toString(client.execute(new HttpGet(uri)).getEntity());
        System.out.println(result);
    }


    //无参GET
    public static void testGetNoParams() throws IOException {
        HttpClient client = HttpClients.createDefault();
        //创建请求地址
        HttpGet get = new HttpGet("http://localhost:80/test");
        //接受响应对象
        HttpResponse response = client.execute(get);
        //获取响应体。响应数据是基于Http协议标准字符串封装的对象
        //所以，响应体和响应头都是封装的HTTP协议数据，直接使用可能有乱码或解析错误
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");

        System.out.println("服务器响应数据{"+responseString+"}");

        //回收资源
        client=null;
    }
}
