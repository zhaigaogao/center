package learn.center.lucene.learn;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;

public class CJKAnalyzerDemon {
	public static void main(String[] args) {
		Analyzer analyzer = new CJKAnalyzer();
		try {
			TokenStream ts = analyzer.tokenStream("myFiled", "上海自来水来自海上。");
			ts.reset();
			while(ts.incrementToken()){
				System.out.println("token"+ts);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
