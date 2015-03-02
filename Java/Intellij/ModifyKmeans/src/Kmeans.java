import java.util.ArrayList;

/**
 * Created by Risky on 2015/1/7.
 */
public class Kmeans {




    public void train(double[][] features, int K, double[][] clusterCenters, int[] clusterIndex) {


        boolean flag = true;                        //如果中心没有改变，则flag为false，算法停止，否则继续

        randomSelectclusterCenters(features, K, clusterCenters);

        //申请K个ArrayList存放K个聚类的样本
        ArrayList<ArrayList<double[]>> al = new ArrayList<ArrayList<double[]>>();
        for (int i = 0; i < K; i++) {
            ArrayList<double[]> tem = new ArrayList<double[]>();
            al.add(tem);
        }
        while (flag) {
            for (int i = 0; i < features.length; i++) {
                int index = minDistance(features[i], clusterCenters);
                ArrayList<double[]> a = al.get(index);
                a.add(features[i]);
                clusterIndex[i] = index;
            }

            //重算聚类中心
            double[][] newClusterCenters = new double[clusterCenters.length][clusterCenters[0].length];
            for (int j = 0; j < K; j++) {
                ArrayList<double[]> b = al.get(j);
                double[] center = new double[features[0].length];
                for (int n = 0; n < b.size(); n++) {
                    double[] tem = b.get(n);
                    for (int m = 0; m < tem.length; m++) {
                        center[m] = center[m] + tem[m] / b.size();
                    }
                }
                b.clear();
                newClusterCenters[j] = center;
            }
            flag = false;
            for (int p = 0; p < clusterCenters.length; p++) {
                for (int q = 0; q < clusterCenters[0].length; q++) {
                    if (clusterCenters[p][q] != newClusterCenters[p][q]) {
                        flag = true;
                        clusterCenters[p][q] = newClusterCenters[p][q];
                    }
                }
            }

        }

    }


    /**
     * ********************************************功能函数****************************************************
     */

    /*
     *
     * 随机选K个不重复的簇心
     * */
    private void randomSelectclusterCenters(double[][] features, int K,
                                            double[][] clusterCenters) {

        int[] tem = new int[K];                    //找出K个不重复的簇心,tem是临时数组
        for (int j = 0; j < K; j++) {
            tem[j] = -1;
        }
        for (int i = 0; i < K; i++) {
            boolean lop = false;
            int r = (int) (Math.random() * features.length);
            for (int m = 0; m < K; m++) {
                if (tem[m] == r) {                    //随机的值跟之前的重复，重来
                    i--;
                    lop = true;
                    break;
                }
            }
            if (lop == false) {                            //随机出的r值跟之前的值不重复
                clusterCenters[i] = features[r];
                tem[i] = r;
            }

        }
    }


    /*
     * 计算每个样本与各个簇心的距离，并选出最小距离，返回最小距离所在的聚类的index
     * */

    private int minDistance(double[] ds, double[][] clusterCenters) {

        int index = -1;
        double[] distance = new double[clusterCenters.length];
        for (int i = 0; i < clusterCenters.length; i++) {
            double dis = 0;
            for (int j = 0; j < ds.length; j++) {
                dis = dis + (ds[j] - clusterCenters[i][j]) * (ds[j] - clusterCenters[i][j]);
            }
            distance[i] = dis;
        }
        double min = Double.MAX_VALUE;
        for (int m = 0; m < distance.length; m++) {
            if (min >= distance[m]) {
                min = distance[m];
                index = m;
            }
        }
        return index;
    }


}
