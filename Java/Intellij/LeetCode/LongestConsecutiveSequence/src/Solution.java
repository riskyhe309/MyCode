import java.util.HashMap;

/**
 * Created by Risky on 2015/1/9.
 */
public class Solution {
    public int longestConsecutive(int[] num) {

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        int lcs = 0;
        for(int n : num){
            if(!map.containsKey(n)){
                int left = map.containsKey(n-1)?map.get(n-1):0;
                int right = map.containsKey(n+1)?map.get(n+1):0;

                int total = left + right + 1;

                map.put(n,total);
                map.put(n-left,total);
                map.put(n+right,total);

                lcs = lcs < total? total:lcs;
            }

            else
                continue;
        }

        return lcs;
    }
}