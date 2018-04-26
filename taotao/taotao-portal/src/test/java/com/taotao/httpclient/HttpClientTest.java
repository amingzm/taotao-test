package com.taotao.httpclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClientTest {

	@Test
	public void testHttpGet() throws Exception, IOException {
		//创建HttpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建一个HttpGet对象,指定url
		HttpGet get = new HttpGet("http://www.sogou.com");
		//执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		//接收返回结果，HttpEntity对象
		org.apache.http.HttpEntity entity = response.getEntity();
		//取响应内容
		String html = EntityUtils.toString(entity);
		System.out.println(html);
		//关闭HttpClient,response
		response.close();
		httpClient.close();
	}
	
	@Test
	public void testHttpPost() throws Exception {

		//创建HttpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建一个HttpGet对象,指定url
		HttpPost post = new HttpPost("http://localhost:8081/posttest.html");
		//创建list模拟表单
		List<NameValuePair> formList = new ArrayList<>();
		formList.add(new BasicNameValuePair("name", "zhangsan"));
		formList.add(new BasicNameValuePair("pass", "1234"));
		//把表单包装进Entity对象中，StringEntity
		StringEntity entity = new UrlEncodedFormEntity(formList);
		post.setEntity(entity);
		//执行请求
		CloseableHttpResponse response = httpClient.execute(post);
		//接收返回结果，HttpEntity对象
		org.apache.http.HttpEntity httpEntity = response.getEntity();
		//取响应内容
		String html = EntityUtils.toString(httpEntity);
		System.out.println(html);
		//关闭HttpClient,response
		response.close();
		httpClient.close();
	}
}
