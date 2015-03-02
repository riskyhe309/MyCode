package sentiment_dict;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Select_Words {

	public static void main(String[] args) throws IOException {

		String input = "C:/Users/Risky/Downloads/dataset_602156/words.txt";
		BufferedReader br = new BufferedReader(new FileReader(new File(input)));
		String line = null;

		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

		String output = "C:/Users/Risky/Downloads/dataset_602156/SelectWords.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(output)));

		while ((line = br.readLine()) != null) {

			String[] strs = line.split("\\s");

			for (String s : strs) {

				if (map.containsKey(s)) {

					List<Integer> temp = map.get(s);   
					temp.add(line.length());
					map.put(s, temp);
					continue;

				}

				List<Integer> strList = new ArrayList<Integer>();
				strList.add(line.length());
				map.put(s, strList);

			}

		}

		br.close();

		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();

		while (it.hasNext()) {

			String word = it.next();

			ArrayList<Integer> list = (ArrayList<Integer>) map.get(word);

			int num = list.size();

			int lenth = 1;

			for (Integer i : list) {

				lenth += i;

			}

			double Tf_long = Math.log(num) / Math.log(lenth);

			bw.write(word + " " + Tf_long);
			bw.newLine();

		}

		bw.flush();
		bw.close();

	}
}
