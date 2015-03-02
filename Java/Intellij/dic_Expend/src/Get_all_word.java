import java.io.*;

/**
 * Created by Risky on 2014/11/24.
 */
public class Get_all_word {

    public static void main(String[] args) throws IOException {

        File fe = new File("C:/Users/Risky/Downloads/dataset_602156/wordSetNLPIR");

        File[] allFile = fe.listFiles();


        for (int i = 0; i < allFile.length; i++) {

            if (!allFile[i].isFile())
                continue;
            System.out.println(i);
            System.out.println(allFile[i].getName());
            File output = new File("C:/Users/Risky/Downloads/" +
                    "dataset_602156/wordSetNLPIR/S/S_word" + i + ".txt");
            BufferedReader br1 = new BufferedReader(new FileReader(allFile[i]));
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(output));



            S_words sw = new S_words(br1, bw1);

            sw.getSwords();

            File sFile = new File("C:/Users/Risky/Downloads/" +
                    "dataset_602156/wordSetNLPIR/candidate/candidateWords" + i + ".txt");
            BufferedReader br2 = new BufferedReader(new FileReader(output));
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(sFile));
            SelectCandidateWord scw = new SelectCandidateWord(br2, bw2);
            scw.getCandidate();
        }
    }
}
