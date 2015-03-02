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

public class loc_Impor_word {

	public static void main(String[] args) throws IOException {
		Map<String, Double> map = new HashMap<String, Double>();

		String input1 = "C:/Users/Risky/Downloads/dataset_602156/DF_Words.txt";
		BufferedReader br1 = new BufferedReader(new FileReader(new File(input1)));
		String line1 = null;
		while ((line1 = br1.readLine()) != null) {

			String[] strings = line1.split(" ");

			if (strings[0] == null)
				continue;
			Double valueInteger = Double.valueOf(strings[1]);
			map.put(strings[0], valueInteger);

		}
		br1.close();

		String input = "C:/Users/Risky/Downloads/dataset_602156/words.txt";
		BufferedReader br = new BufferedReader(new FileReader(new File(input)));
		String line = null;

		String out = "C:/Users/Risky/Downloads/dataset_602156/loc_import.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(out)));

		int indexDoc = 0;
		while ((line = br.readLine()) != null && indexDoc < 800000) {

			indexDoc++;

			String[] strs = line.split("\\s");

			Map<String, Double> temp = new HashMap<String, Double>();

			int i = 0;

			for (String s : strs) {
				i++;
				Double value = temp.get(s);

				if (value == null) {
					value = 1.0 / i;
				} else
					value += 1.0 / i;
				temp.put(s, value);
			}

			Set<String> set = temp.keySet();
			Iterator<String> iterator = set.iterator();
			while (iterator.hasNext()) {
				String string = iterator.next();
				Double valueInteger = temp.get(string);
				Double df = map.get(string);
				double tf_idf = (((double) valueInteger) / strs.length) * Math.log(((double) 800000) / (df + 1));
				bw.write(string + " " + String.format("%.2f", tf_idf) + " ");
			}
			bw.newLine();

		}

		bw.flush();
		bw.close();
		br.close();

	}

}
