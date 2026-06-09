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
        Queue<Integer> pq = new PriorityQueue<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                TreeNode curr = q.poll();
                if (curr != null) {
                    pq.offer(curr.val);
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < k; i++) {
            result = pq.poll();
        }
        
        return result;
    }
}
