package learn.center.lucene.learn;

import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;

public class AnalysisDemon {
	public static void main(String[] args) {
		Analyzer analyzer = new SmartChineseAnalyzer();
		
		try {
			//获取Token流
			TokenStream ts = analyzer.tokenStream("myfield", new StringReader("咬死了猎人的狗。"));
			ts.reset();
			while(ts.incrementToken()){
				System.out.println("token:"+ts);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
