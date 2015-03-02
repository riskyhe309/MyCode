/**
 * Created by Risky on 2015/3/2.
 */
public class Solution {
    public void rotate(int[] nums, int k) {

        int length = nums.length;

        if( k % length == 0)
            return;

        if(length % k != 0){
            int begin = 0;
            int temp = nums[begin];

            while(true){

                int next = (begin + k) % length;

                if(next == 0){
                    nums[0] = temp;
                    break;
                }


                nums[0] = nums[next];
                nums[next] = temp;
                temp = nums[0];
                begin = next;
            }
        }
        else{
            int cycle = k - 1;
            while(cycle >= 0){

                int begin = cycle;
                int temp = nums[begin];

                while(true){

                    int next = (begin + k) % length;
                    if(next == cycle){
                        nums[cycle] = temp;
                        cycle--;
                        break;
                    }
                    nums[cycle] = nums[next];
                    nums[next] = temp;
                    temp = nums[cycle];
                    begin = next;
                }
            }
        }

    }
}