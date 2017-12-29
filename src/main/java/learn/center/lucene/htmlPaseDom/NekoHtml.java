package learn.center.lucene.htmlPaseDom;

import org.cyberneko.html.parsers.DOMParser;

public class NekoHtml {
	public static void main(String[] args) {
		try {
			DOMParser parser = new DOMParser();
			parser.parse("https://www.baidu.com/");
			System.out.println(parser.getDocument());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("IO异常！");
		}
	}
}
