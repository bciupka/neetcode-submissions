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
    public int maxDepth(TreeNode root) {
        int[] max = new int[1];

        visit(root, 1, max);
        
        return max[0];
    }

    private void visit(TreeNode curr, int level, int[] max) {
        if (curr == null) return;

        if (level > max[0]) {
            max[0] = level;
        }

        visit(curr.left, level + 1, max);
        visit(curr.right, level + 1, max);
    }
}
