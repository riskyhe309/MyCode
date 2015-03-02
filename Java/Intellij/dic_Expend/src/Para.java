import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Para {
	public static void main(String[] args) throws IOException {
		String input = "C:/Users/Risky/Downloads/dataset_602156/all_sinaweibo.txt";

		BufferedReader br = new BufferedReader(new FileReader(new File(input)));
		String line = null;

		String output = "C:/Users/Risky/Downloads/dataset_602156/sinaweibo.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(output)));

		//int i = 0;
		
		while ((line = br.readLine()) != null) {

			if (line.startsWith("<TEXT>")) {
				line = line.substring(6, line.length() - 7);
				bw.write(line);
				bw.newLine();
				//i++;
			}

		}

		bw.flush();
		bw.close();
		br.close();
	}

}
