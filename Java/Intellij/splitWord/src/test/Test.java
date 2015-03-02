package test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Risky on 2015/1/13.
 */
public class Test {


    public static void main(String[] args){
        String t1 = "家居服  法兰绒";
        String t2 = "冬日 暖阳";

        System.out.println(new Test().computT2T(t1,t2));


    }

    public double computT2T(String t1, String t2) {

        if (t1 == null || t2 == null)
            return 0;

        Set<Character> character1 = new HashSet<Character>();
        Set<Character> character2 = new HashSet<Character>();
        Set<Character> totalChar = new HashSet<Character>();

        char[] char1s = t1.replaceAll("\\S+", "").toCharArray();
        char[] char2s = t2.replaceAll("\\S+", "").toCharArray();

        for (Character c : char1s) {
            character1.add(c);
            totalChar.add(c);
        }

        for (Character c : char2s) {
            character2.add(c);
            totalChar.add(c);
        }

        int[] vector1 = new int[totalChar.size()];
        int[] vector2 = new int[totalChar.size()];

        int i = 0;
        for (char c : totalChar) {
            if (character1.contains(c))
                vector1[i] = 1;
            else
                vector1[i] = 0;
            if (character2.contains(c))
                vector2[i] = 1;
            else
                vector2[i] = 0;
            i++;
        }

        double length1 = 0;
        double length2 = 0;
        double product = 0;

        for (i = 0; i < vector1.length; i++) {
            length1 += vector1[i];
            length2 += vector2[i];
            product += vector1[i] * vector2[i];
        }

        return product / (Math.sqrt(length1) * Math.sqrt(length2));
    }

}
