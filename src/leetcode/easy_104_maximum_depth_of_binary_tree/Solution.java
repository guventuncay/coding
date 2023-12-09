package leetcode.easy_104_maximum_depth_of_binary_tree;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public static void main(String[] args) {
        TreeNode input = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(maxDepth2(input));
    }

    // recursive dfs
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // bfs
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            count++;
        }
        return count;
    }

    // iterative dfs
    public static int maxDepth3(TreeNode root) {
        var stack = new Stack<Map.Entry<TreeNode, Integer>>();
        stack.add(Map.entry(root, 1));

        int max = 0;
        while (!stack.isEmpty()) {
            var pop = stack.pop();
            TreeNode node = pop.getKey();
            Integer depth = pop.getValue();

            if (node != null) {
                max = Math.max(max, depth);
                stack.add(new AbstractMap.SimpleEntry<>(node.left, depth + 1));
                stack.add(new AbstractMap.SimpleEntry<>(node.right, depth + 1));
            }
        }
        return max;
    }
}