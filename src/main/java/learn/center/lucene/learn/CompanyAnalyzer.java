package learn.center.lucene.learn;

import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;

public class CompanyAnalyzer extends Analyzer {

	@Override
	protected TokenStreamComponents createComponents(String fileName) {
//		TokenStream stream = new ComTokenizer();
		return null;
	}

}
