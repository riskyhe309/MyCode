import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Risky on 2015/1/26.
 */
public class CommonKnowledge {

    Set<Set<String>> Commonset;

    Set<String> isCommonKnowledge(ArrayList<String> al) throws IOException {

        loadSet("C:\\Users\\Risky\\Desktop\\set");

        int maxSimi = 0;
        Set<String> suitSet = null;

        for (Set<String> set:Commonset){

            int tempSimi = 0;
            for (String s:al)
                tempSimi += computSemi(set,s);

            if (tempSimi > maxSimi){
                maxSimi = tempSimi;
                suitSet = set;
            }

        }


        if (maxSimi > 0)
            return suitSet;
        else
            return null;

    }


    //计算s和set的相似度，或者叫契合度
    //comput the similarity between s and set
    private int computSemi(Set<String> set, String s) {
        //int temp = 0;
        if (set.contains(s))
            return 1;
        return 0;
    }


    //遍历set文件，添加共有知识集合
    //load the set files
    //parameter is a directory not file
    void loadSet(String directory) throws IOException {
        Commonset = new HashSet<Set<String>>();

        //String setFile = "";
        //BufferedReader br = new BufferedReader(new FileReader(new File(setFile)));

        File dir = new File(directory);

        File[] files = dir.listFiles();

        for (File f:files){

            BufferedReader br = new BufferedReader(new FileReader(f));

            Set<String> temp = new HashSet<String>();

            String line = null;

            while((line = br.readLine()) != null)
                temp.add(line);

            Commonset.add(temp);

        }
    }
}
