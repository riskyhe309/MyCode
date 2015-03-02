import java.io.*;
import java.util.Date;

/**
 * Created by Risky on 2014/12/1.
 */
public class CreatDict {

    public static void main(String[] args) throws IOException {

        File feCandidates = new File("C:/Users/Risky/Downloads/dataset_602156/wordSetNLPIR/result/1/candidate");

        File[] allFileCandidate = feCandidates.listFiles();

        File feWords = new File("C:/Users/Risky/Downloads/dataset_602156/wordSetNLPIR/result/1/wordsNoPos");
        File[] allFileWords = feWords.listFiles();

        String outputNeg = "C:/Users/Risky/Downloads/dataset_602156/wordSetNLPIR/result/1/wordSetNeg.txt";
        BufferedWriter bwNeg = new BufferedWriter(new FileWriter(new File(outputNeg)));

        String outputPos = "C:/Users/Risky/Downloads/dataset_602156/wordSetNLPIR/result/1/wordSetPos.txt";
        BufferedWriter bwPos = new BufferedWriter(new FileWriter(new File(outputPos)));

        Date dB = new Date();
        for (int i = 0; i < allFileCandidate.length; i++) {
            Date da = new Date();
            System.out.println("开始于"+da);
            if (!allFileCandidate[i].isFile())
                continue;
            if (!allFileWords[i].isFile())
                continue;
           // System.out.println("第" + i + "轮");
            BufferedReader br1 = new BufferedReader(new FileReader(allFileCandidate[i]));
            BufferedReader br2 = new BufferedReader(new FileReader(allFileWords[i]));

            Get_Dict_Word gdw = new Get_Dict_Word(br1, br2, bwNeg, bwPos);

            gdw.getSentiment();
            Date db = new Date();
            //System.out.println("结束于"+db);
            System.out.println("一次总共用时"+(db.getTime() - da.getTime()) / (1000 * 60)+"分钟");
            br1.close();
            br2.close();

        }
        Date dF = new Date();
        System.out.println("总共用时"+(dF.getTime() - dB.getTime()) / (1000 * 60)+"分钟");
        bwNeg.close();
        bwPos.close();

    }
}
