package leetcode.easy_226_invert_binary_tree;

import leetcode.util.TreeNode;

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
        TreeNode input = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode actual = invertTree(input);
        System.out.println(actual);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return new TreeNode(root.val, invertTree(root.right), invertTree(root.left));
    }
}