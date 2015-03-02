
import java.util.*;

/**
 * Created by Risky on 2014/12/29.
 */
public class CreateTable {

    public ArrayList<String[]> creatTable(Set <String[]>  lists, int k){

        ArrayList <String[]> result = new ArrayList<String[]>();

        ArrayList<Set<String>> SF = new ArrayList<Set<String>>();

        /*
        *if the spilted list is bigger than k, then resplist it
        *
         **/
        for (String[] strs: lists){
            if (strs.length > k) ;

            //重新切分长记录

            

             //   AlingLongRecord;
        }



        Set <String[]> shortRecord = new TreeSet<String[]>();

        for (String[] record: lists){

            if (record.length < k){
                shortRecord.add(record);
                continue;
            }

            result.add(record);

            //SF = v
            updateSF(record,SF);
        }

        Cluster.cluster(shortRecord, SF, result);

        return result;
    }

    private void updateSF(String[] record, ArrayList<Set<String>> sf) {

        int k = record.length;
        for (int i = 0; i < record.length; i++){

            //add the record for the candidate summary
            sf.get(i).add(record[i]);

            Set<String> temp = sf.get(i);

            if (temp.size() > 3){

                //updata the most representation of the summary

                double minscore = Double.MAX_VALUE;
                String worestrep = null;


                //没有F2FC 没有写完！！！

              /*  for (String s:temp){
                    double score = F2FC(s,temp);
                    if (score < minscore){
                        minscore = score;
                        worestrep = s;
                    }
                }*/
                sf.get(i).remove(worestrep);
            }

        }


    }
}
