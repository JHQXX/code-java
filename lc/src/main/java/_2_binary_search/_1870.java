package _2_binary_search;

/**
 * @Author: Lee
 * @Description: 二分答案-最小值
 * @DateTime: 2026/5/7 上午10:13
 **/
public class _1870 {


    public static void main(String[] args) {
        int[] dist = {1,3,2};

        minSpeedOnTime(dist,2.7);
    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        //hour 是时间 dist 是表示第i辆车 速度越高 时间越少
        if(dist.length-1 > hour){
            return -1;
        }
        int minL = 1;
        //计算得来 考虑最坏的情况 最后的一个最长距离 100000  和最短时间 0.01
        int maxL = 10000000;
        int res = -1;
        while(minL <= maxL){
            int mid = (maxL - minL)/2 + minL;
            double ans = conut(dist,mid);
            if(ans > hour){
                minL = mid +1;
            }else{
                res = mid;
                maxL = mid -1;
            }
        }
        return res;
    }

    public static double conut(int[] dist , int speed ){
        double ans = 0.00;
        for(int i = 0 ; i < dist.length;i++){
            if(i == dist.length-1){
                //向上取整-最后一个不用 其他需要
                ans += (double) dist[i]/speed;
            }else{
                ans +=(double)(dist[i]+speed-1)/speed;
            }
        }
        return ans;
    }


}
