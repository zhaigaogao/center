package learn.center.lucene.htmlPaseDom;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupHtml {
	public static void main(String[] args) {
		try {
			//获取网页内容
			URL pageUrl = new URL("https://www.baidu.com/");
			InputStream is = pageUrl.openStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuilder content = new StringBuilder();
			while ((line = bf.readLine())!=null) {
				content.append(line);
				System.out.println(line);
			}
			System.out.println(content);
			
			System.out.println("***********************");
			//对网页内容进行解析
			Document doc = Jsoup.connect("https://www.baidu.com/").get();  
			String title = doc.title();
			System.out.println(title);
			System.out.println(doc.select("img[src]"));
			System.out.println(doc.select("a[href]").html());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("IO异常");
		}
	}
}
