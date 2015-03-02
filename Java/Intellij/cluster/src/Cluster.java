import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Risky on 2014/12/29.
 */
public class Cluster {

    public static Set<String[]> cluster(Set<String[]> lists, ArrayList<Set<String>> SF,
                                        ArrayList<String[]> result) {

        int length = result.get(0).length;

        for (String[] strs : lists) {

            String[] tempRecord = new String[length];
            int loadedNull = 0;
            for (int i = 0; i < strs.length; i++) {
                // if (loadedNull < length - strs.length) {

                double minScore = Double.MAX_VALUE;
                int index = i + loadedNull;

                for (int j = index; j < length && loadedNull < length - strs.length; j++) {

                    // compute the F2FC between strs[i] and the
                    // SF[j] (3 elements), then get the average score

                    double score = Double.MAX_VALUE;

                   /* for (String s:SF[j]){
                         score += F2FC(s,temp)/SF.get(j).size();


                     if (score < minScore){
                        minScore = score;
                        index = j;
                        }
                        */
                }

                // insert the null term
                for (; i + loadedNull < index; loadedNull++) {

                    tempRecord[i + loadedNull] = " ";
                }

                tempRecord[index] = strs[i];

            }

        }
        return null;
    }
}
