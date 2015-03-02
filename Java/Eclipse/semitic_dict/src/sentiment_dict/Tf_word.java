package sentiment_dict;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import java.util.Map;
import java.util.Set;

public class Tf_word {

	public static void main(String[] args) throws IOException {

		String input = "C:/Users/Risky/Downloads/dataset_602156/words.txt";
		BufferedReader br = new BufferedReader(new FileReader(new File(input)));
		String line = null;

		String output = "C:/Users/Risky/Downloads/dataset_602156/TFWords.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(output)));

		Map<String, Integer> map = new HashMap<String, Integer>();

		int docnum = 0;
		while ((line = br.readLine()) != null && docnum < 10000) {

			docnum++;
			String[] strs = line.split("\\s");

			for (String s : strs) {

				Integer value = map.get(s);

				if (value == null) {
					value = 1;
				} else
					value++;
				map.put(s, value);
			}
		}

		br.close();

		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		int index = 0;
		while (it.hasNext()) {
			String s = it.next();
			Integer integer = map.get(s);
			if (integer > 8000) {
				bw.write(s + " " + integer);
				index++;
				if (index % 20 == 0)
					bw.newLine();
			}
		}
		bw.flush();
		bw.close();

	}
}
