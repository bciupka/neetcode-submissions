/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        rec(root);
        return max;

    }

    private int rec(TreeNode root) {
        if (root == null) return 0;

        int l = rec(root.left);
        int r = rec(root.right);

        max = Math.max(max, (l + r));

        return Math.max(l, r) + 1;
    }
}
