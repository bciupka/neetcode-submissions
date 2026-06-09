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
    public int kthSmallest(TreeNode root, int k) {
        int[] temp = new int[2];
        temp[0] = k;
        
        rec(root, temp);

        return temp[1];
    }

    private void rec(TreeNode curr, int[] temp) {
        if (curr == null) return;

        rec(curr.left, temp);
        
        if (temp[0] == 0) return;
        temp[0]--;
        temp[1] = curr.val;
        if (temp[0] == 0) return;

        rec(curr.right, temp);
    }
}
