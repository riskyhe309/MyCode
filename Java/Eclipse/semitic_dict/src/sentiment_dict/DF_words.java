package sentiment_dict;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DF_words {

	public static void main(String[] args) throws IOException {

		String input = "C:/Users/Risky/Downloads/dataset_602156/words.txt";
		BufferedReader br = new BufferedReader(new FileReader(new File(input)));
		String line = null;

		Map<String, HashSet<Integer>> map = new HashMap<String, HashSet<Integer>>();

		String output = "C:/Users/Risky/Downloads/dataset_602156/DF_Words.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(output)));

		Integer docIndex = 0;
		while ((line = br.readLine()) != null && docIndex < 800000) {

			docIndex++;

			String[] strs = line.split("\\s");

			for (String s : strs) {

				if (map.containsKey(s)) {

					HashSet<Integer> temp = map.get(s);
					temp.add(docIndex);
					map.put(s, temp);
					continue;

				}

				HashSet<Integer> strList = new HashSet<Integer>();

				strList.add(docIndex);
				map.put(s, strList);

			}

		}

		br.close();

		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String string = iterator.next();
			HashSet<Integer> valueHashSet = map.get(string);

			bw.write(string + " " + valueHashSet.size());
			bw.newLine();

		}

		bw.flush();
		bw.close();
	}
}
