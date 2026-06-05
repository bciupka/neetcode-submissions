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
        boolean a = false;
        if (root.val == subRoot.val) {
            Stack<TreeNode[]> stack = new Stack<>();
            stack.push(new TreeNode[]{root, subRoot});

            while (!stack.isEmpty()) {
                TreeNode[] nodes = stack.pop();
                TreeNode n1 = nodes[0], n2 = nodes[1];

                if (n1 == null && n2 == null) continue;
                if (n1 == null || n2 == null || n1.val != n2.val) {
                    a = false;
                    break;
                }
                stack.push(new TreeNode[]{n1.left, n2.left});
                stack.push(new TreeNode[]{n1.right, n2.right});
                a = true;
            }
        }

        boolean b = isSubtree(root.left, subRoot);
        boolean c = isSubtree(root.right, subRoot);

        return a || b || c;
    }
}
