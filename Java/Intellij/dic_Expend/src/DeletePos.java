
import java.io.*;


/**
 * Created by Risky on 2014/12/8.
 */
public class DeletePos {



    public static void main(String[] args) throws IOException {

        File feCandidates = new File("C:/Users/Risky/Downloads/dataset_602156/wordSetNLPIR/result/1/words");

        File[] allFileCandidate = feCandidates.listFiles();

        String out = "C:/Users/Risky/Downloads/dataset_602156/wordSetNLPIR/result/1/wordsNoPos/";

        for (int i = 0; i < allFileCandidate.length; i++) {

            if (!allFileCandidate[i].isFile())
                continue;

            BufferedReader br = new BufferedReader(new FileReader(allFileCandidate[i]));

            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(out+"wordsNoPos"+i+".txt")));

            String line;
            while (true){
                if ((line = br.readLine()) == null) break;

                String[] tempLine = line.split("\\s+");

                for (String s: tempLine){
                    String[] tempStr = s.split("/");
                    if (tempStr[0].matches("[^\u4e00-\u9fa5]+") || tempStr[0].startsWith("@"))
                        continue;
                    bw.write(tempStr[0]+" ");
                }

                bw.newLine();

            }
            bw.flush();
            bw.close();

        }




    }
}
