/**
 * Created by Risky on 2014/12/24.
 */
public class Solution {
    public int compareVersion(String version1, String version2) {

        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");

        String[] shortVer = ver1;

        if (shortVer.length == 0){
            shortVer = new String[1];
            shortVer[0] = version1;
        }

        String[] longVer = ver2;

        if (longVer.length == 0){
            longVer = new String[1];
            longVer[0] = version2;
        }


        int short1 = -1;

        if(ver1.length > ver2.length){
            shortVer = ver2;
            longVer = ver1;
            short1 = 1;
        }

        for(int i = 0; i < longVer.length; i++){
            long longNum = Long.parseLong(longVer[i]);

            long shortNum = 0;

            if (i < shortVer.length)
                shortNum = Long.parseLong(shortVer[i]);

            if(shortNum > longNum )
                return (-1)*short1;
            if(shortNum < longNum)
                return short1;
        }
        return 0;
    }
}