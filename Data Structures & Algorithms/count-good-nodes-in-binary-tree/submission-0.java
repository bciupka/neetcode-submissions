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
    int res;

    public int goodNodes(TreeNode root) {
        res = 0;     
    
        rec(root, Integer.MIN_VALUE);
    
        return res;
    }

    private void rec(TreeNode root, int max) {
        if (root == null) return;

        if (root.val >= max) {
            res++;
            max = root.val;
        }

        rec(root.left, max);
        rec(root.right, max);
    }
}
