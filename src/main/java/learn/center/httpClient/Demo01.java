package learn.center.httpClient;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * httpClient
 * @author zhaieryuan
 * @date 2017年9月21日 上午9:16:58
 */
public class Demo01 {
	private static HttpClient httpClient;
	
	public static String doPost(String url,String port,String data) throws HttpException, IOException{
		PostMethod post = new PostMethod();
		post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
 		if(data != null && !"".equals(data.trim())){
 			NameValuePair[] param = {new NameValuePair("param",URLEncoder.encode(data,"UTF-8"))};
 		}else {
			post.setRequestBody(data);
		}
 		String respStr = "";
 		post.getParams().setContentCharset("UTF-8");
 		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(30000);
 		httpClient.executeMethod(post);
 		respStr = URLDecoder.decode(post.getResponseBodyAsString(),"UTF-8");
		return respStr;
		
	}
	
	public static void main(String[] args) {
		
	}
}
