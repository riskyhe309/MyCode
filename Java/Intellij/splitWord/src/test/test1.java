package test;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Risky on 2015/1/13.
 */
public class test1 {

    public static void main(String[] args) {

    /*
    *
    * 主函数 测试用
    * */


        try {
            String input = "C:\\Users\\Risky\\Desktop\\1.txt";
            BufferedReader br = new BufferedReader(new FileReader(new File(input)));

            String output = "C:\\Users\\Risky\\Desktop\\2.txt";

            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(output)));

            ArrayList<ArrayList<String>> aal = new ArrayList<ArrayList<String>>();

            String line = null;

            int length = 0;

            while ((line = br.readLine()) != null) {

                String[] strs = line.split("\\s+");


                length = length > strs.length ? length : strs.length;

                ArrayList<String> temp = new ArrayList<String>();
                for (String st : strs) {
                    //分词并且提取关键词
                    temp.add(SplitWords.splitMethod(st));
                }
                aal.add(temp);
            }

            br.close();


            //为短的arraylist补齐
            for (ArrayList<String> al : aal) {
                for (int i = al.size(); i < length; i++) {
                    al.add(i,"#");
                }
            }

            ArrayList<ArrayList<String>> re = new ModifyKmeans().cluster(aal, 3);

            for (ArrayList<String> al : re) {
                for (String reStr : al) {
                    System.out.print(reStr + "    ");
                    bw.write(reStr + "    ");
                }
                bw.newLine();
                System.out.println();
            }
            bw.flush();
            bw.close();

        } catch (Exception e) {

            e.printStackTrace();
          //  System.out.println(e + "  读取/写入文件错误");
        }


    }

}
