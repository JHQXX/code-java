package _2_binary_search;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2026/5/11 上午11:28
 **/
public class _78 {

    public static void main(String[] args) {
        rampartDefensiveLine(new int[][]{{1,2},{5,8},{11,15},{18,25}});
    }
    public static int rampartDefensiveLine(int[][] rampart) {
        //找其中的最小值 一个坐标里面
        int left = 0;
        int right = rampart[rampart.length-1][0] - rampart[0][1];
        int ans = 0;

        // 1. 计算总长度
        int totalLength = 0;
        for (int[] row : rampart) {
            totalLength += row.length;
        }

        // 2. 初始化一维数组
        int[] arr = new int[totalLength];

        // 3. 填充元素
        int index = 0;
        for (int[] row : rampart) {
            for (int element : row) {
                arr[index++] = element;
            }
        }

        while(left <= right){
            int mid = (right - left)/2 + left;
            if(check(arr ,mid)){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return ans;
    }

    public static boolean check(int[] arr , int mid ){
        for(int i = 2 ; i < arr.length-2 ; i++){
            //左边界
            int left = arr[i];
            int right = arr[i+1];

            //上层
            int downRight = arr[i-1];
            int upLeft = arr[i+2];
            int count = 0;
            count += left - downRight;
            count += upLeft - right;
            if(count < mid){
                return false;
            }
            i++;
        }
        return true;
    }
}
