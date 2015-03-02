package sentiment_dict;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class S_words {

	public static void main(String[] args) throws IOException {

		Map<String, Double> mapbigram = new HashMap<String, Double>();

		Map<String, Double> mapword = new HashMap<String, Double>();

		String input = "C:/Users/Risky/Downloads/dataset_602156/words.txt";
		BufferedReader br = new BufferedReader(new FileReader(new File(input)));
		String line = null;
		int index = 0;
		while ((line = br.readLine()) != null && index < 500000) {

			index++;
			String[] strings = line.split("\\s");

			/*
			 * if (strings.length < 1) continue;
			 * 
			 * // add the first words Double valueDouble =
			 * mapword.get(strings[0]); if (valueDouble == null) valueDouble =
			 * 1.0; else { valueDouble++; } mapword.put(strings[0],
			 * valueDouble);
			 */

			for (int i = 0; i < strings.length + 1; i++) {

				// add the words
				if (i < strings.length) {
					Double value = mapword.get(strings[i]);
					if (value == null)
						value = 1.0;
					else {
						value++;
					}
					mapword.put(strings[i], value);
				}

				String keyString = null;
				if (i == 0) {

					keyString = " " + " " + strings[i];

				} else if (i == strings.length) {

					keyString = strings[i - 1] + " " + " ";

				} else {

					keyString = strings[i - 1] + " " + strings[i];
				}

				Double bigramDouble = mapbigram.get(keyString);

				if (bigramDouble == null)
					bigramDouble = 1.0;
				else {
					bigramDouble++;
				}

				mapbigram.put(keyString, bigramDouble);
			}

		}
		br.close();

		String input1 = "C:/Users/Risky/Downloads/dataset_602156/wordSet/words0.txt";
		BufferedReader br1 = new BufferedReader(new FileReader(new File(input1)));
		// String line1 = null;

		String out = "C:/Users/Risky/Downloads/dataset_602156/wordSet/S/S_word0.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(out)));

		// System.out.println(mapword.size() + " " + mapbigram.size());

		line = null;

		while ((line = br1.readLine()) != null) {

			String[] str = line.split("\\s");

			if (str.length < 2) {				
				continue;
			}

			double s1s2 = mapbigram.get(str[0] + " " + str[1]) + 1;
			double s1s0 = mapbigram.get(" " + " " + str[0]) + 1;
			double s2 = mapword.get(str[1]);
			double s1 = mapword.get(str[0]);
			double sword0 = (s1s0 * s1s2 * mapword.size() + 1) / (s2 * s1 * s1 + 1);

			if (sword0 > 1e-3) {
				bw.write(str[0] + " " + String.format("%.3f", sword0) + " ");
			}

			int i = 1;
			for (; i < str.length - 1; i++) {

				double si0 = mapword.get(str[i - 1]);
				double si1 = mapword.get(str[i]);
				double si2 = mapword.get(str[i + 1]);

				double sis0 = mapbigram.get(str[i - 1] + " " + str[i]) + 1;
				// System.out.println(str[i] + " " + str[i + 1]);
				double sis2 = mapbigram.get(str[i] + " " + str[i + 1]) + 1;

				double swordi = (mapword.size() * sis0 * sis2 + 1) / (si0 * si1 * si2 + 1);

				if (sword0 > 1e-3) {
					bw.write(str[i] + " " + String.format("%.3f", swordi) + " ");
				}

			}

			double sns1 = mapbigram.get(str[i - 1] + " " + str[i]) + 1;
			double sns2 = mapbigram.get(str[i] + " " + " ") + 1;
			double sn0 = mapword.get(str[i - 1]);
			double sn1 = mapword.get(str[i]);
			double swordn = (sns1 * sns2 * mapword.size() + 1) / (sn0 * sn1 * sn1 + 1);
			if (sword0 > 1e-3) {
				bw.write(str[i] + " " + String.format("%.3f", swordn) + " ");
			}
			

			bw.newLine();

		}
		br1.close();
		bw.flush();
		bw.close();
	}
}
