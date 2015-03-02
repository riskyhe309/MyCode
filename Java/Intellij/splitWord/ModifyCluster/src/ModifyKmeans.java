import java.io.*;
import java.util.*;

/**
 * Created by Risky on 2015/1/7.
 */
public class ModifyKmeans {


    final double minF2FS = 0.3;  //点与类心之间的最小距离；

    final int minNum = 10;       // 类别的最小点数；

    ArrayList<ArrayList<String>> list;        //待对齐的列表

    //待聚类的字符串在list中的行标和列标
    class ArrayLabel{
        int row;
        int col;
        ArrayLabel(int row, int col){
            this.row = row;
            this.col = col;
        }

       /* boolean equals(ArrayLabel a,ArrayLabel b){
            if (a.col == b.col && a.row == b.row)
                return true;
            return false;
        }*/
    }

    public ArrayList<ArrayList<String>> cluster(ArrayList<ArrayList<String>> list, int k) {

        //int[][] clusterIndex = new int[list.size()][k];

        this.list = list;

        boolean flag = true;                        //如果中心没有改变，则flag为false，算法停止，否则继续



        //类的中心
        ArrayList<Set<ArrayLabel>> clusterCenters = new ArrayList<Set<ArrayLabel>>();

        //随机选取类心
        randomSelectclusterCenters(list, k, clusterCenters);

        //利用ArrayLabel来聚类
        ArrayList<Set<ArrayLabel>> asa = new ArrayList<Set<ArrayLabel>>();

        for (int i = 0; i < k; i++) {
            Set<ArrayLabel> tem = new HashSet<ArrayLabel>();
            asa.add(tem);
        }

        int iteration = 0;

        while (flag && iteration < 10) {

            allocationLabel(list, k, clusterCenters, asa);

            ArrayList<ArrayList<String>> alal = new ArrayList<ArrayList<String>>();

       /*
        *
        *
        * 将包含数目少的类别删除，并重新分配类别中的点
        *
        * */
//            for (Set<ArrayLabel> al:asa){
//                if (al.size() < minNum){
//
//                }
//
//            }



            //重算聚类中心
            ArrayList<Set<ArrayLabel>> newClusterCenters = new ArrayList<Set<ArrayLabel>>();

            recomputCenter(clusterCenters, asa, newClusterCenters);

            flag = false;

            for (int p = 0; p < clusterCenters.size(); p++) {
                if (!clusterCenters.get(p).equals(newClusterCenters.get(p))){
                    flag = true;
                    break;
                }
            }

           iteration++;

        }

        /*
        *
        *
        * 将包含数目少的类别删除，并重新分配类别中的点
        *
        *
        *
        *
        *
        *
        *
        *
        * */

        //将ArrayLabel转换成字符串返回
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        for (int i = 0; i < asa.size();i++){

            ArrayList<String> temp = new ArrayList<String>();

            //第i个类别
            Set<ArrayLabel> colLabel = asa.get(i);

            for (ArrayLabel al: colLabel){
                temp.add(find(al)); //第i个类别中的元素在list中对应的文本
            }

            result.add(temp);
        }
        return result;
    }



    /*
    * 重新计算每个类的类心 ，类心至多有三个
    * 选取最中心的几个点
    * */
    private void recomputCenter(ArrayList<Set<ArrayLabel>> clusterCenters, ArrayList<Set<ArrayLabel>> al,
                                ArrayList<Set<ArrayLabel>> newClusterCenters) {

        for (int j = 0; j < clusterCenters.size(); j++) {

            Set<ArrayLabel> b = al.get(j);

            //选取类心标准，至多选取三个点作为类心

            Map<ArrayLabel, Double> map = new HashMap<ArrayLabel, Double>();

            for (ArrayLabel tempAl:b) {


                double centerF2FC = totalF2FScore(tempAl, b);

                map.put(tempAl, centerF2FC);

                if (map.size() > 3) {

                    ArrayLabel minF2FC = null;
                    double min = Double.MAX_VALUE;
                    Set<ArrayLabel> key = map.keySet();
                    for (ArrayLabel mapKey : key) {
                        double value = map.get(tempAl);
                        if (value < min) {
                            min = value;
                            minF2FC = mapKey;
                        }
                    }
                    map.remove(minF2FC);
                }

            }
            b.clear();
            newClusterCenters.set(j, map.keySet());
        }
    }


    /*
    * 计算每个点与类心的F2FS,选取最大的f2fs（大于阈值）对应的类别，作为改点的类别，
    * 如果最大的f2fs小于阈值，则添加新类别，并将该店加入新的类别
    * */
    private void allocationLabel(ArrayList<ArrayList<String>> list, int k,
                                 ArrayList<Set<ArrayLabel>> clusterCenters,
                                 ArrayList<Set<ArrayLabel>> al) {

        for (int i = 0; i < list.size(); i++) {

            for (int j = 0; j < k; j++) {

                ArrayLabel tempAl = new ArrayLabel(i,j);

                int index = -1;
                double minFS = Double.MAX_VALUE;

                for (int m = 0; m < clusterCenters.size(); m++) {

                    double f2fs = totalF2FScore(tempAl, clusterCenters.get(m));

                    if (f2fs < minFS) {
                        minFS = f2fs;
                        index = m;
                    }
                }

                if (minFS < minF2FS) {    //与任意一个类心都不匹配，则添加新的类心

                    Set<ArrayLabel> a = new HashSet<ArrayLabel>();

                    a.add(tempAl);

                    al.add(a);

                    // 添加新的类心
                    Set<ArrayLabel> newCenter = new HashSet<ArrayLabel>();
                    newCenter.add(tempAl);
                    index = clusterCenters.size();
                    clusterCenters.add(index, newCenter);
                    //clusterIndex[i][j] = index;

                } else {

                    Set<ArrayLabel> a = al.get(index);

                    a.add(tempAl);

                    //clusterIndex[i][j] = index;
                }


            }
        }
    }



    /*
    * 计算s与collections中所有点的f2fs的和
    * */
    private double totalF2FScore(ArrayLabel s, Collection<ArrayLabel> collections) {

        String str = find(s);
        double re = 0;
        for(ArrayLabel al:collections){
            String center = find(al);
            re += computT2T(str,center);
        }

        return re;

    }

    /*
    * 找出ArrayLabel代表的字符串
    * */
    private String find(ArrayLabel s) { return list.get(s.row).get(s.col);}


    /*
    * the first time every center just has one element
    *
    * */
    private void randomSelectclusterCenters(ArrayList<ArrayList<String>> features, int K,
                                            ArrayList<Set<ArrayLabel>> clusterCenters) {

        int[] tem = new int[K];                    //找出K个不重复的簇心,tem是临时数组

        for (int j = 0; j < K; j++) {
            tem[j] = -1;
        }

        for (int i = 0; i < K; i++) {
            boolean lop = false;
            int q = (int) (Math.random() * features.size());
            int r = (int) (Math.random() * features.size());
            for (int m = 0; m < K; m++) {
                if (tem[m] == r) {                    //随机的值跟之前的列重复，重来
                    i--;
                    lop = true;
                    break;
                }
            }
            if (lop == false) {                            //随机出的r值跟之前的值不重复
                Set<ArrayLabel> tempSet = new HashSet<ArrayLabel>();
                tempSet.add( new ArrayLabel(q,r));
                clusterCenters.add(i, tempSet);
                tem[i] = r;
            }

        }
    }


    /*
    * 按字计算文本的相似度
    * */
    public double computT2T(String t1, String t2) {

        Set<Character> character1 = new HashSet<Character>();
        Set<Character> character2 = new HashSet<Character>();
        Set<Character> totalChar = new HashSet<Character>();

        char[] char1s = t1.toCharArray();
        char[] char2s = t2.toCharArray();

        for (Character c : char1s) {
            character1.add(c);
            totalChar.add(c);
        }

        for (Character c : char2s) {
            character2.add(c);
            totalChar.add(c);
        }

        int[] vector1 = new int[totalChar.size()];
        int[] vector2 = new int[totalChar.size()];

        int i = 0;
        for (char c : totalChar) {
            if (character1.contains(c))
                vector1[i] = 1;
            else
                vector1[i] = 0;
            if (character2.contains(c))
                vector2[i] = 1;
            else
                vector2[i] = 0;
            i++;
        }

        double length1 = 0;
        double length2 = 0;
        double product = 0;

        for (i = 0; i < vector1.length; i++) {
            length1 += vector1[i];
            length2 += vector2[i];
            product += vector1[i] * vector2[i];
        }

        return product / (Math.sqrt(length1) * Math.sqrt(length2));
    }

}
