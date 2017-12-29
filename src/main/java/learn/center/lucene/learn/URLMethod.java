package learn.center.lucene.learn;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;

public class URLMethod {
	public static void main(String[] args) {
		System.out.println("****************");
		System.out.println(downloadPage("https://devnj.zhaiugo.com/zhaiugo-dl-web/login.jsp;JSESSIONID=55b36535-5ff9-4538-9258-622942971226"));
		System.out.println("****************");
	}
	
	public static String downloadPage(String path){
		try {
			URL pageUrl = new URL(path);
			//创建网络流
			InputStream stream  = pageUrl.openStream();
			InputStreamReader streamReader = new InputStreamReader(stream);
			BufferedReader reader = new BufferedReader(streamReader);
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				sb.append(line);
			}
			
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static String socketDownloadPage(String host,String file,int port){
		try {
			Socket s= new Socket();
			OutputStream out = s.getOutputStream();
			PrintWriter outw = new PrintWriter(out,false);
			outw.print("GET "+ file + "HTTP/1.0\r\n");
			outw.print("Accept: text/plain, text/html, text/*\r\n");
			outw.print("\r\n");
			outw.flush();
			
			InputStream in = s.getInputStream();
			InputStreamReader streamReader = new InputStreamReader(in,"UTF-8");
			BufferedReader reader = new BufferedReader(streamReader);
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
