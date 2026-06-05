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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (root.val == subRoot.val) {
            if (rec(root, subRoot)) return true;
        }

        boolean a = isSubtree(root.left, subRoot);
        boolean b = isSubtree(root.right, subRoot);

        return a || b;

    }

    private boolean rec(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.val != n2.val) return false;

        boolean a = rec(n1.left, n2.left);
        boolean b = rec(n1.right, n2.right);

        return a && b;
    }
}
