import java.util.ArrayList;

/**
 * Created by Risky on 2015/1/21.
 */
public class PrefixOrSuffix {


    String isPrefixOrSuffix(ArrayList<String> al){

        StringBuffer prefix = new StringBuffer();
        StringBuffer suffix = new StringBuffer();

        int index = 0;
        //int sufindex = 0;
        boolean preFlag = true;
        boolean sufFlag = true;

        int minLength = Integer.MAX_VALUE;
        for (String str :al){
            if(str.length() < minLength){
                minLength = str.length();
            }
        }


        while((preFlag | sufFlag) && index < minLength){


            //对照字符串
            String comparisonString = al.get(0);

            char pre = ' ';
            char suf = ' ';


            //第几个前缀
           if (preFlag){
                pre = comparisonString.charAt(index);
                prefix.append(pre);
            }


            //第几个后缀
            if (sufFlag){
                suf = comparisonString.charAt(comparisonString.length() - index - 1);
                suffix.insert(0, suf);
            }



            for (String str: al){

                //如果有一个单词，起前缀与对照前缀不同则结束前缀比较
                if (preFlag && str.charAt(index) != pre){
                    preFlag = false;
                    prefix.deleteCharAt(index);
                }

                //类似前缀的比较
                if (sufFlag && str.charAt(str.length() - index - 1) != suf){
                    sufFlag = false;
                    suffix.deleteCharAt(0);
                }
            }
            index++;
        }

        return prefix+"**"+suffix;

    }
}
