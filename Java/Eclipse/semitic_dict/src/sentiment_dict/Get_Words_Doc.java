package sentiment_dict;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Get_Words_Doc {
	public static void main(String[] args) throws IOException {

		String input = "C:/Users/Risky/Downloads/dataset_602156/sinaweibo.txt";
		BufferedReader br = new BufferedReader(new FileReader(new File(input)));
		String line = null;

		String output = "C:/Users/Risky/Downloads/dataset_602156/words.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(output)));

		while ((line = br.readLine()) != null) {

			line = Split_Data.split(line);
			bw.write(line);
			bw.newLine();
		}

		bw.close();
		br.close();
	}
}
