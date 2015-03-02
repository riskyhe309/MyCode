import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class splitFile {

    public static void main(String[] args) throws IOException {

        String input = "C:/Users/Risky/Downloads/dataset_602156/words_NLPIR.txt";
        BufferedReader br = new BufferedReader(new FileReader(new File(input)));

        String line ;
        int index = 0;

        String output = "C:/Users/Risky/Downloads/dataset_602156/wordSetNLPIR/words_NLPIR0.txt";

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(output)));

        while ((line = br.readLine()) != null) {


            /*if (index < 1000000)
                continue;*/

            if (index % 100000 == 0) {
                bw.flush();
                output = "C:/Users/Risky/Downloads/dataset_602156/wordSetNLPIR/words_NLPIR" + (index / 100000) + ".txt";
                bw = new BufferedWriter(new FileWriter(new File(output)));
            }

            bw.write(line);
            bw.newLine();
            index++;

        }
        bw.close();
        br.close();
    }
}
