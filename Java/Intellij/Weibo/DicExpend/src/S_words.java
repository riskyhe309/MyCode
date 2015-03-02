

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class S_words {


    BufferedReader br1;
    BufferedWriter bw1;

    S_words(BufferedReader brn, BufferedWriter bwn) {

        this.br1 = brn;
        this.bw1 = bwn;
    }

    public void getSwords() throws IOException {

        Map<String, Double> mapbigram = new HashMap<String, Double>();

        Map<String, Double> mapword = new HashMap<String, Double>();

        String input = "C:/Users/Risky/Downloads/dataset_602156/words_NLPIR.txt";
        BufferedReader br = new BufferedReader(new FileReader(new File(input)));
        String line ;
        int index = 0;

        while ((line = br.readLine()) != null && index < 400000 ) {

            index++;
            /*if (index < 1000000)
                continue;
*/
            String[] strings = line.split("\\s+");

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
                    if (strings[i].equals(" ") || strings[i].equals(""))
                        continue;
                    Double value = mapword.get(strings[i]);
                    if (value == null)
                        value = 1.0;
                    else {
                        value++;
                    }
                    mapword.put(strings[i], value);
                }

                String keyString;
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

        //String input1 = "C:/Users/Risky/Downloads/dataset_602156/wordSet/words1.txt";
        //BufferedReader br1 = new BufferedReader(new FileReader(input1));
        // String line1 = null;

        //String out = "C:/Users/Risky/Downloads/dataset_602156/wordSet/S/S_word1.txt";
        //BufferedWriter bw = new BufferedWriter(new FileWriter(output1));

        // System.out.println(mapword.size() + " " + mapbigram.size());

       // line = null;
        //System.out.println(br1.readLine());
        while ((line = br1.readLine()) != null) {

            String[] str = line.split("\\s+");

            if (str.length < 2) {
                continue;
            }

            Double s1s2 = mapbigram.get(str[0] + " " + str[1]);
            if (s1s2 == null)
                s1s2 = 1.0;

            Double s1s0 = mapbigram.get(" " + " " + str[0]);
            if (s1s0 == null)
                s1s0 = 1.0;

            double s2 = mapword.get(str[1]);
            double s1 = mapword.get(str[0]);
            double sword0 = (s1s0 * s1s2 * mapword.size() + 1) / (s2 * s1 * s1 + 1);

            if (sword0 > 1e-3) {
                bw1.write(str[0] + " " + String.format("%.3f", sword0) + " ");
            }

            int i = 1;
            for (; i < str.length - 1; i++) {

                double si0 = mapword.get(str[i - 1]);
                double si1 = mapword.get(str[i]);
                double si2 = mapword.get(str[i + 1]);

                Double sis0 = mapbigram.get(str[i - 1] + " " + str[i]);
                if (sis0 == null)
                    sis0 = 1.0;
                // System.out.println(str[i] + " " + str[i + 1]);
                Double sis2 = mapbigram.get(str[i] + " " + str[i + 1]);
                if (sis2 == null)
                    sis2 = 1.0;

                double swordi = (mapword.size() * sis0 * sis2 + 1) / (si0 * si1 * si2 + 1);

                if (swordi > 1e-3) {
                    bw1.write(str[i] + " " + String.format("%.3f", swordi) + " ");
                }

            }

            Double sns1 = mapbigram.get(str[i - 1] + " " + str[i]);
            if (sns1 == null)
                sns1 = 1.0;
            Double sns2 = mapbigram.get(str[i] + " " + " ");
            if (sns2 == null)
                sns2 = 1.0;
            double sn0 = mapword.get(str[i - 1]);
            double sn1 = mapword.get(str[i]);
            double swordN = (sns1 * sns2 * mapword.size() + 1) / (sn0 * sn1 * sn1 + 1);
            if (swordN > 1e-3) {
                bw1.write(str[i] + " " + String.format("%.3f", swordN) + " ");
            }

            bw1.newLine();

        }
        br1.close();
        bw1.flush();
        bw1.close();
    }
}
