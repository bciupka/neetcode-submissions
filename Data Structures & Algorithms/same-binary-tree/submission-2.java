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
        Queue<TreeNode> qp = new LinkedList<>();
        Queue<TreeNode> qq = new LinkedList<>();

        qp.offer(p);
        qq.offer(q);

        while (!qp.isEmpty()) {
            TreeNode n1 = qp.poll();
            TreeNode n2 = qq.poll();

            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val) return false;

            qp.offer(n1.left);
            qp.offer(n1.right);
            qq.offer(n2.left);
            qq.offer(n2.right);
        }

        return true;
    }
}
