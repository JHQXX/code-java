package _2_binary_search;

/**
 * @Author: Lee
 * @Description: 二分答案-最大值
 * @DateTime: 2026/5/8 上午9:36
 **/
public class _275 {

    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 当前文章及其右边的所有文章数量
            int hCandidate = n - mid;

            // 如果当前文章的引用次数 >= 候选的 H 指数
            if (citations[mid] >= hCandidate) {
                // 说明从 mid 到 n-1 这些文章都符合要求，记录下这个 hCandidate
                ans = hCandidate;
                // 尝试寻找更小的索引（即更大的 H 指数）
                right = mid - 1;
            } else {
                // 引用次数太少，必须往右找（减小 H 指数，增加单篇引用门槛）
                left = mid + 1;
            }
        }
        return ans;
    }
}
