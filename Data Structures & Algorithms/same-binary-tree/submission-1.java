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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode[]> s = new Stack<>();
        s.push(new TreeNode[]{p, q});

        while (!s.isEmpty()) {
            TreeNode[] nodes = s.pop();
            TreeNode n1 = nodes[0], n2 = nodes[1];

            if (n1 == null && n2 == null) continue;

            if (n1 == null || n2 == null || n1.val != n2.val) return false;

            s.push(new TreeNode[]{n1.left, n2.left});
            s.push(new TreeNode[]{n1.right, n2.right});
        }

        return true;
    }
}
