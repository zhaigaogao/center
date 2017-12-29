package learn.center.lucene.learn;

import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

public class StandarAnalyzerDemon {
	public static void main(String[] args) {
		
		Analyzer analyzer = new StandardAnalyzer();
		try {
			TokenStream ts = analyzer.tokenStream("myfiled", new StringReader("上海自来水来自海上。"));
			ts.reset();
			while(ts.incrementToken()){
				System.out.println("token:"+ts);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
