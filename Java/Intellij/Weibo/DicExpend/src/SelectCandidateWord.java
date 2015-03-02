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

    BufferedReader br2;
    BufferedWriter bw;

    SelectCandidateWord(BufferedReader br, BufferedWriter bw) {

        this.br2 = br;
        this.bw = bw;
    }

    public void getCandidate() throws IOException {

        String input = "C:/Users/Risky/Downloads/senmitic/neg-seed.txt";
        BufferedReader br = new BufferedReader(new FileReader(new File(input)));
        Set<String> candidateSet = new HashSet<String>();
        String line;

        while ((line = br.readLine()) != null) {
            String[] strings = line.split("\\s+");
            if (!strings[0].equals(" "))
                candidateSet.add(strings[0]);


        }
        br.close();

        String input1 = "C:/Users/Risky/Downloads/senmitic/pos-seed.txt";
        BufferedReader br1 = new BufferedReader(new FileReader(new File(input1)));

        while ((line = br1.readLine()) != null) {
            String[] strings = line.split("\\s+");
            if (!strings[0].equals(" "))
                candidateSet.add(strings[0]);


        }
        br1.close();

        //String out = "C:/Users/Risky/Downloads/dataset_602156/wordSet/candidate/candidateWords1.txt";

        // BufferedWriter bw = new BufferedWriter(new FileWriter(output));

        // String input2 = "C:/Users/Risky/Downloads/dataset_602156/wordSet/S/S_word1.txt";
        // BufferedReader br2 = new BufferedReader(new FileReader(input));


        while (true) {
            if (((line = br2.readLine()) == null)) break;
            String[] strings = line.split("\\s+");
            Double minS = Double.MAX_VALUE;
            for (int i = 0; i < strings.length; i = i + 2) {

                String[] tempStr = strings[i].split("/");

                if (tempStr[0].equals(" ") || tempStr[0].equals("")) {
                    continue;
                }

               // String[] tempStr = strings[i].split("/");

                if (candidateSet.contains(tempStr[0])) {
                    double s = Double.valueOf(strings[i + 1]);
                    if (minS > s) {
                        minS = s;
                    }
                }
            }

            /*if (minS == 0)
                continue;*/
            for (int i = 0; i < strings.length - 1; i = i + 2) {
                if (Double.valueOf(strings[i + 1]) >= minS) {
                    candidateSet.add(strings[i]);
                }
            }

        }

        Set<String> pos = new HashSet<String>();
        pos.add("a");
        pos.add("n");
        pos.add("d");
        pos.add("v");
        pos.add("ad");
        pos.add("an");
        pos.add("vi");
        pos.add("happ");
        //pos.add("udel");
       // pos.add("o");

        for (String aCandidateSet : candidateSet) {
            String[] tempStr = aCandidateSet.split("/");
            if (tempStr.length < 2 || !pos.contains(tempStr[1]))
                continue;
            if (tempStr[0].length() > 4 || tempStr[0].length() < 2 || tempStr[0].matches("[^\u4e00-\u9fa5]+"))
                continue;

            bw.write(tempStr[0]);
            bw.newLine();
        }
        bw.flush();
        bw.close();

        br2.close();

    }
}
