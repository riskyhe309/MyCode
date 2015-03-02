package sentiment_dict;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;

import net.paoding.analysis.analyzer.PaodingAnalyzer;

public class Split_Data {

	private static Set<String> stopSet = new HashSet<String>();
	
	public static String split(String line) throws IOException {
		
		loadStopWord();
		
		Analyzer analyzer = new PaodingAnalyzer();

		//String indexStr = line.replaceAll("[^\u4e00-\u9fa5]+", ""); // 汉字

		String result = "";
		try {
			StringReader reader = new StringReader(line);
			TokenStream ts = analyzer.tokenStream(line, reader);
			Token t;
			t = ts.next();
			while (t != null) {
				
				if (!t.termText().matches("[\u4e00-\u9fa5]+")) {
					t = ts.next();
					continue;
				}
				
				result = result + t.termText() + " ";
				t = ts.next();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
		
	}

	private static void loadStopWord() throws IOException {
		
		String input = "C:/Users/Risky/Downloads/dataset_603466/StopWords.txt";
		BufferedReader br = new BufferedReader(new FileReader(new File(input)));
		String line = null;
		
		while ((line = br.readLine()) != null) {		
			stopSet.add(line);
		}
		br.close();
		
		
	}

}
