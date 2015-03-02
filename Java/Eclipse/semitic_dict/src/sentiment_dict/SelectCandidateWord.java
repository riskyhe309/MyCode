package sentiment_dict;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SelectCandidateWord {

	public static void main(String[] args) throws IOException {

		String input = "C:/Users/Risky/Downloads/senmitic/neg-seed.txt";
		BufferedReader br = new BufferedReader(new FileReader(new File(input)));
		Set<String> setNeg = new HashSet<>();
		String line = null;

		while ((line = br.readLine()) != null) {
			String[] strings = line.split("\\s+");
			if (strings[0] != " ") {
				setNeg.add(strings[0]);
			}
			

		}
		br.close();

		String input1 = "C:/Users/Risky/Downloads/senmitic/pos-seed.txt";
		BufferedReader br1 = new BufferedReader(new FileReader(new File(input1)));
		Set<String> setPos = new HashSet<>();
		line = null;

		while ((line = br1.readLine()) != null) {
			String[] strings = line.split("\\s+");
			if (strings[0] != " ") {
				setPos.add(strings[0]);
			}
			

		}
		br1.close();

		String out = "C:/Users/Risky/Downloads/dataset_602156/wordSet/candidate/candidateWords.txt";

		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(out)));

		String input2 = "C:/Users/Risky/Downloads/dataset_602156/wordSet/S/S_word0.txt";
		BufferedReader br2 = new BufferedReader(new FileReader(new File(input2)));

		Set<String> candidateSet = new HashSet<String>();

		line = null;

		while ((line = br2.readLine()) != null) {
			String[] strings = line.split("\\s+");
			double minS = 0;
			for (int i = 0; i < strings.length; i = i + 2) {
				if (strings[i] == "") {
					continue;
				}
				if (setNeg.contains(strings[i]) || setPos.contains(strings[i])) {
					
					double s = Double.valueOf(strings[i + 1]);
					if (minS > s) {
						minS = s;
					}
				}
			}

			for (int i = 0; i < strings.length; i = i + 2) {
				if (Double.valueOf(strings[i + 1]) >= minS) {
					candidateSet.add(strings[i]);
				}
			}

		}

		Iterator<String> iterator = candidateSet.iterator();
		while (iterator.hasNext()) {
			bw.write(iterator.next());
			bw.newLine();
		}
		bw.flush();
		bw.close();

		br2.close();

	}
}
