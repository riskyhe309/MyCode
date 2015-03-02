import java.io.*;
import java.util.ArrayList;

/**
 * Created by Risky on 2015/1/27.
 */
public class Test {

    public static void main(String[] args) {


        try {
            String input = "C:\\Users\\Risky\\Desktop\\1.txt";
            BufferedReader br = new BufferedReader(new FileReader(new File(input)));

            String output = "C:\\Users\\Risky\\Desktop\\2.txt";

            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(output)));

            ArrayList<ArrayList<String>> aal = new ArrayList<ArrayList<String>>();

            String line = null;

            while((line = br.readLine()) != null){

                String[] strs = line.split(" \\|+ ");

                ArrayList<String> temp = new ArrayList<String>();
                for (String st:strs)
                    temp.add(st);

                aal.add(temp);
            }
            br.close();

            ArrayList<ArrayList<String>> re = new ModifyKmeans().cluster(aal,4);

            System.out.println(re.size()+"...................");

            for (ArrayList<String> al : re){
                for (String reStr:al){
                    System.out.print(reStr + " || ");
                    bw.write(reStr+" || ");
                }
                bw.newLine();
                System.out.println();
            }
            bw.flush();
            bw.close();

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println(e+"  读取/写入文件错误");
        }



    }
}
