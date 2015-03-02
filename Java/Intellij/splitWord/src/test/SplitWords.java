package test;

import com.sun.jna.Native;
import study.CLibrary;

/**
 * Created by Risky on 2015/1/13.
 */
public class SplitWords {

    public static String  splitMethod(String line) {

        // 初始化
        CLibrary instance = (CLibrary) Native.loadLibrary(System.getProperty("user.dir") +
                        "\\source\\NLPIR",
                CLibrary.class);
        int init_flag = instance.NLPIR_Init("", 1, "0");
        String resultString = null;
        if (0 == init_flag) {
            resultString = instance.NLPIR_GetLastErrorMsg();
            System.err.println("初始化失败！\n" + resultString);
            return null;
        }

      //  String line = "冬日里的暖阳";

        try {
//            resultString = instance.NLPIR_ParagraphProcess(line, 0);
//            System.out.println("分词结果为：\n " + resultString);

            resultString = instance.NLPIR_GetKeyWords(line, 10, false);
           // System.out.println("从段落中提取的关键词：\n" + resultString);

            instance.NLPIR_Exit();
        }catch (Exception e) {
            System.out.println("错误信息：");
            e.printStackTrace();
        }

        return resultString.replaceAll("#","  ");
    }
}
