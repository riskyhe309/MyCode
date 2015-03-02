import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Risky on 2014/10/26.
 */
public class Solution {

    public List<String> wordBreak(String s, Set<String> dict) {

        List<String> result = new ArrayList<String>();

        List<Pair> pairs = new ArrayList<Pair>();

        //contains the pairs of word's begin and end
        for (int i = s.length() - 1; i >= 0; i--) {
            String str = s.substring(i);


            List<Pair> temPairs = new ArrayList<Pair>();

            for (Pair tem : pairs) {
                int beg = tem.begin;

                String subs = s.substring(i, beg);

                if (dict.contains(subs)) {
                    String tempStr = subs + " " + tem.str;
                    temPairs.add(new Pair(i, tempStr));
                }
            }
            pairs.addAll(temPairs);

            if (dict.contains(str))
                pairs.add(new Pair(i, str));

        }

        for (Pair pairList : pairs) {
            if (pairList.begin == 0)
                result.add(pairList.str);

        }

        return result;
    }


    public class Pair {

        protected int begin;
        protected String str;

        public Pair(int begin, String str) {
            this.begin = begin;
            this.str = str;
        }
    }
}