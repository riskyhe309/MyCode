/**
 * Created by Risky on 2015/3/2.
 */
public class Test {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6};
        Solution sl = new Solution();
        sl.rotate(nums,2);

        for(int i:nums){
            System.out.println(i);
        }
    }
}
