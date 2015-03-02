import java.util.ArrayList;

/**
 * Created by Risky on 2015/1/14.
 */
public class Solution {

    public String largestNumber(int[] num) {
        int largest = 0;

        ArrayList<String> al = new ArrayList<String>();
        for (int i : num) {
            al.add(i + "");
            /*if(i > largest)
                largest = i;*/
        }

        // int k = (largest+"").length();

        radixSort(al, 0, 0, al.size());

        StringBuffer sb = new StringBuffer();
        if (al.get(0).equals("0"))
            return "0";
        for (String i : al) {
            sb.append(i + ",");
        }

        return sb.toString();
    }

    public static void radixSort(ArrayList<String> al, int l, int star, int end) {

        /*ArrayList<String> re  = new ArrayList<String>();
        re.addAll(al);*/

       /* if ((end - star) < 2)
            return;*/
        String[][] tempString = new String[10][end - star];

        int[] orderNum = new int[10];

        // for(int i = l; i < k; i++ ){
        while ((end - star) > 2) {

            for (int j = star; j < end; j++) {

                String temp = al.get(j);

                char ith = temp.charAt(l % temp.length());
                //l < temp.length()?temp.charAt(l):temp.charAt(0);

                int order = (int) ith - (int) '0';

                tempString[order][orderNum[order]] = temp;

                orderNum[order]++;

            }

            //al.clear();

            int index = star;
            for (int m = 9; m >= 0; m--) {
                int subStar = index;
                if (orderNum[m] != 0) {
                    for (int j = 0; j < orderNum[m]; j++) {
                        al.set(index, tempString[m][j]);
                        index++;
                    }
                    radixSort(al, l + 1, subStar, index);
                }

                orderNum[m] = 0;
            }

        }
    }
}
