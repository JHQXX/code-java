package _2_binary_search;


import _0_data_structures.TreeNode;
import lombok.extern.slf4j.Slf4j;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2026/4/22 下午4:12
 **/
@Slf4j
public class _2476_closestNodes {

    public static void main(String[] args) {
        Integer[] data = {6, 2, 13, 1, 4, 9, 15, null, null, null, null, null, null, 14};
        Integer[] queries  = {2,5,16};
        TreeNode treeNode = TreeNode.constructTree(data);
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.closestNodes(treeNode, List.of(queries));
        ObjectMapper objectMapper = new ObjectMapper();
        log.info("输出 {}",objectMapper.writeValueAsString(lists));

    }
}


class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> sortedList = new ArrayList<>();
        // 1. 中序遍历将树转为有序列表
        inorder(root,sortedList);
        List<List<Integer>> ansList = new ArrayList<>();
        int n = sortedList.size();
        for (int query : queries) {
            int a = -1, b = -1;

            // 2. 二分查找
            // 使用自定义二分或库函数。这里演示手动查找左边界逻辑
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (sortedList.get(mid) <= query) {
                    a = sortedList.get(mid);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            left = 0; right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (sortedList.get(mid) >= query) {
                    b = sortedList.get(mid);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            ansList.add(Arrays.asList(a, b));
        }
        return ansList;
    }
    private void inorder(TreeNode node , List<Integer> list){
        if(node == null) return;
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }

}
