import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Risky on 2015/2/6.
 */
public class Solution {

    class Pair {
        int x;   //当前s1中字符的最大下标，这个字符当前已经确认在s3中
        int y;

    /*    boolean equals(Pair p){
            return p.x == this.x && p.y == this.y;
        }*/

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        Set<Integer> visited = new HashSet<Integer>();
        Queue<Pair> queue = new LinkedList<Pair>();

        int length1 = s1.length();
        int length2 = s2.length();

        /*if (length1 + length2 != s3.length())
            return false;*/

        queue.add(new Pair(-1, -1));

        Pair last = new Pair(length1 - 1, length2 - 1);

        while (!queue.isEmpty()) {

            Pair work = queue.poll();

            /*if(work.equals(last))
                return true;
*/
            int x = work.x + 1;   //试探s1的下一个char是否合适（此时，s3中包含有s1中的x个字符（work.x + 1），所以s1中的当前最大下标为x - 1）
            int y = work.y + 1;

            if (x == length1 && y == length2)
                return x + y == s3.length();

            if (x < length1 && s1.charAt(x) == s3.charAt(x + y)) {  //当前字符个数为x+y，当前字符下标为x+y-1，s3中下一个字符下标为x + y
                Pair cur = new Pair(x, y - 1);
                if (visited.add((x + 1) * (length2 + 1) + y))
                    queue.add(cur);
            }

            if (y < length2 && s2.charAt(y) == s3.charAt(x + y)) {
                Pair cur = new Pair(x - 1, y);
                if (visited.add(x * (length2 + 1) + y + 1))
                    queue.add(cur);
            }
        }
        return false;
    }

}
