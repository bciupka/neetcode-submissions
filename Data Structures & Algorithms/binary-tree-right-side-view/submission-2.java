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
    List<Integer> res;

    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>(); 
        rec(root, 0);
        return res;
    }

    private void rec(TreeNode root, int depth) {
        if (root == null) return;

        if (depth == res.size()) {
            res.add(root.val);
        }
        
        depth++;
        rec(root.right, depth);
        rec(root.left, depth);
    }
}
