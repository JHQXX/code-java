package _0_data_structures;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2026/4/22 下午4:15
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val,TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode constructTree(Integer[] nums) {
        if (nums == null || nums.length == 0) return null;

        // 1. 创建根节点
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1; // 数组指针
        while (!queue.isEmpty() && i < nums.length) {
            TreeNode current = queue.poll();

            // 2. 处理左孩子
            if (i < nums.length && nums[i] != null) {
                current.left = new TreeNode(nums[i]);
                queue.add(current.left);
            }
            i++;

            // 3. 处理右孩子
            if (i < nums.length && nums[i] != null) {
                current.right = new TreeNode(nums[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
}

