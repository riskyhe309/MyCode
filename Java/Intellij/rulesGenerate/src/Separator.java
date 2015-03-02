import java.util.ArrayList;

/**
 * Created by Risky on 2015/1/26.
 */
public class Separator {


    String isSeparator(ArrayList<String> al){

        if (al.size() == 0)
            return null;

        String separator = al.get(0);

        for (int i = 1; i < al.size(); i++){
            String temp = al.get(i);
            separator = findCommonString(temp,separator);

        }

        return separator;
    }



    //find the common string, because the separator is not at the begin or end so
    //we can start find at the second character and end  at the length() - 1

    private String findCommonString(String str1, String sep) {

        StringBuffer sb = new StringBuffer();

        for(int i = 1; i < str1.length() - 1; i++)
            for (int j = 0; j < sep.length(); j++){
                if (str1.charAt(i) == sep.charAt(j)){
                    sb.append(str1.charAt(i));
                    break;
                }

            }

        return sb.toString();


    }
}
