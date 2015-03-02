import java.util.*;

/**
 * Created by Risky on 2015/1/7.
 */
public class Test {

    public double computT2T(String t1, String t2) {

        Set<Character> character1 = new HashSet<Character>();
        Set<Character> character2 = new HashSet<Character>();
        Set<Character> totalChar = new HashSet<Character>();

        char[] char1s = t1.toCharArray();
        char[] char2s = t2.toCharArray();

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
