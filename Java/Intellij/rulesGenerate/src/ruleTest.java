import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Risky on 2015/1/21.
 */
public class ruleTest {
    public static void main(String[] args) throws IOException {
        PrefixOrSuffix rule = new PrefixOrSuffix();

        ArrayList<String> al = new ArrayList<String>();
        al.add("啊是九分裤中国出版社");
        al.add("凤凰中国出版社");
        al.add("乌鸦中国出版社");
        al.add("飞鸟中国出版社");


        String[] str = rule.isPrefixOrSuffix(al).split("\\*+");
        System.out.println(str.length);
        System.out.println(str[0]);
        System.out.println(str[1]);
    }
}
