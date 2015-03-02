import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by Risky on 2015/1/26.
 */
public class Regexp {

    Pattern isRegexp(ArrayList<String> al) {

        //时间


        //日期,
        Pattern date = Pattern.compile("/^[0-2][0-3]:[0-5][0-9]:[0-5][0-9]$");
        //时间
        Pattern time = Pattern.compile("/^(\\d{4})-(0\\d{1}|1[0-2])-(0\\d{1}|[12]\\d{1}|3[01])$/");
        //邮箱
        Pattern mail = Pattern.compile("/^[a-z]([a-z0-9]*[-_]?[a-z0-9]+)*" +
                "@([a-z0-9]*[-_]?[a-z0-9]+)+[\\.][a-z]{2,3}([\\.][a-z]{2})?$");
        //小数
        Pattern decimal = Pattern.compile("/^-?[^\\D]+\\.?[^\\D]+$");
        //整数
        Pattern integer = Pattern.compile("^-?[0-9]\\d*$");

        if (al.size() == 0)
            return null;

        Pattern[] ps = {date, time, mail, decimal, integer};

        Pattern pattern = null;

        for (Pattern p : ps) {
            if (p.matcher(al.get(0)).matches()) {
                pattern = p;
                break;
            }
        }

        if (pattern == null)
            return null;
        for (String s : al) {
            if (!(pattern.matcher(s).matches())) {
                pattern = null;
                break;
            }

        }

        return pattern;

    }
}
