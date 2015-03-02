import java.util.*;

/**
 * Created by Risky on 2015/1/11.
 */
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {



        if(!dict.contains(end)) return 0;

        Map<String,Integer> map = new HashMap<String,Integer>();

        Queue<String> queue = new LinkedList<String>();

        map.put(start,1);
        queue.add(start);

        while(!queue.isEmpty()){

            String oldWord = queue.poll();
            if(oldWord.equals(end)) break;

            char[] tempChar = oldWord.toCharArray();

            for(int i = 0; i < oldWord.length(); i++){

                char origChar =   tempChar[i];

                for(int j = 0; j < 26; j++){

                    tempChar[i] = (char)((int)'a' + j);

                    String str = new String(tempChar);

                    if(dict.contains(str) && !map.containsKey(str)){
                        map.put(str,map.get(oldWord)+1);
                        queue.add(str);
                    }
                }
                tempChar[i] = origChar;
            }

        }

        Integer value = map.get(end);

        return value == null?0:value;

    }
}