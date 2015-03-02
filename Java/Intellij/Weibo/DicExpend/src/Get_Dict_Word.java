import java.io.*;

import java.util.*;


public class Get_Dict_Word {

    static BufferedReader brCandidate;
    static BufferedReader brWords;
    static BufferedWriter bwNeg;
    static BufferedWriter bwPos;

    Get_Dict_Word(BufferedReader br1, BufferedReader br2, BufferedWriter bw1, BufferedWriter bw2) {

        brCandidate = br1;
        brWords = br2;
        bwNeg = bw1;
        bwPos = bw2;
    }


    static Set<Set<String>> all = new HashSet<Set<String>>();
    // static int allWord = 0;

    static Map<String, Integer> candidates = new HashMap<String, Integer>();

    static double totalPos = 1.0;
    static double totalNeg = 1.0;
    static Map<String, Integer> negMap = new HashMap<String, Integer>();
    static Map<String, Integer> posMap = new HashMap<String, Integer>();


    public static void getSentiment() throws IOException {


        String input = "C:/Users/Risky/Downloads/senmitic/neg-seed.txt";
        BufferedReader brNegSeed = new BufferedReader(new FileReader(new File(input)));


        String input1 = "C:/Users/Risky/Downloads/senmitic/pos-seed.txt";
        BufferedReader brPosSeed = new BufferedReader(new FileReader(new File(input1)));

        getAllSentence(brWords);
        //get the seed words

        getWordMap(negMap, brNegSeed, false);

        getWordMap(posMap, brPosSeed, false);

        getWordMap(candidates, brCandidate, true);

        //Date da = new Date();
        // int index = 0;
        boolean getMap = true;


        Set<String> candidateWord = candidates.keySet();

        for (String candidate : candidateWord) {

/*
            if (index % 10000 == 0) {

                Date db = new Date();
                System.out.println(db);
                System.out.println("第" + (index / 10000) + "个10000用时："
                        + (double) (db.getTime() - da.getTime()) / (1000 * 60));
                da = new Date();
            }
            index++;*/


            // if the candidate word's count is smaller than 500 then drop it
            Integer valueCandidate = candidates.get(candidate);
            if (valueCandidate < 50)
                continue;


            double negNum = getHit(candidate, negMap, getMap);
            double posNum = getHit(candidate, posMap, getMap);

            //getMap = false;

            // compute the totalNeg  and totalPos
            if (getMap) {
                Set<String> keyPos = posMap.keySet();
                for (String s : keyPos) {
                    Integer value = posMap.get(s);
                    totalPos *= (value < 1 ? 1 : value);
                }

                Set<String> keyNeg = negMap.keySet();
                for (String s : keyNeg) {
                    Integer value = negMap.get(s);
                    totalNeg *= (value < 1 ? 1 : value);
                }
                getMap = false;
            }

            //compute the SO_PMI
            double so_PMI = Math.log((posNum / negNum) * (totalNeg / totalPos)) * (negMap.size() / posMap.size());

            //  System.out.println(so_PMI);
            if (so_PMI > 1) {
                bwPos.write(candidate + " " + String.format("%.3f", so_PMI));
                bwPos.newLine();
                bwPos.flush();

            }

            if (so_PMI < -1) {
                bwNeg.write(candidate + " " + String.format("%.3f", so_PMI));
                bwNeg.newLine();
                bwNeg.flush();
            }
        }
    }

    /*private static void getWordSet(Set<String> wordSet, String input) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File(input)));
        String line;

        while ((line = br.readLine()) != null) {
            String[] strings = line.split("\\s+");
            if (strings[0].matches("[\\u4e00-\\u9fa5]+")) {
                wordSet.add(strings[0]);
            }
        }
        br.close();
    }*/

    private static void getWordMap(Map<String, Integer> wordMap, BufferedReader br, boolean compute) throws IOException {

        //BufferedReader br = new BufferedReader(new FileReader(new File(input)));

        String line;

        while ((line = br.readLine()) != null) {
            String[] strings = line.split("\\s+");
            if (strings[0].matches("[\\u4e00-\\u9fa5]+")) {
                wordMap.put(strings[0], 0);
            }
        }
        br.close();

        if (!compute)
            return;

        // compute the value
        for (Set<String> set : all) {
            for (String s : set) {
                if (wordMap.containsKey(s)) {
                    Integer value = wordMap.get(s);
                    wordMap.put(s, value + 1);
                }
            }

        }

    }


    //get all the sentences(corpus)
    private static void getAllSentence(BufferedReader br) throws IOException {


        // String input3 = "C:/Users/Risky/Downloads/dataset_602156/wordSet/result/1/words1/words0.txt";
        //BufferedReader br3 = new BufferedReader(new FileReader(new File(input3)));

        String line;


        // br3.readLine();
        while (true) {
            if ((line = br.readLine()) == null) break;
            String[] str = line.split("\\s+");

            if (str.length < 10)
                continue;
            Set<String> wordTemp = new HashSet<String>();
            Collections.addAll(wordTemp, str);

            all.add(wordTemp);
        }
    }


    //compute the Hit
    private static double getHit(String candidateWords, Map<String, Integer> seedMap, boolean visitedSeed) throws IOException {

        double result;
        result = 1.0;
        int num = 0;

        Set<String> seedSet = seedMap.keySet();

        for (String s : seedSet) {

            for (Set sentence : all) {
                if (sentence.contains(candidateWords) && sentence.contains(s)) {
                    num++;
                }
                if (visitedSeed && sentence.contains(s)) {
                    Integer value = seedMap.get(s);
                    seedMap.put(s, value + 1);
                }

            }

            if (num > 0)
                result *= num;
        }
        return result;

    }
}
