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
    Map<Integer, Integer> lookup = new HashMap<>();
    int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            lookup.put(inorder[i], i);
        }

        return rec(preorder, 0, inorder.length - 1);
    }

    private TreeNode rec(int[] preorder, int l, int r) {
        if (l > r) return null;

        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);
        int m = lookup.get(rootVal);

        root.left = rec(preorder, l, m - 1);
        root.right = rec(preorder, m + 1, r);

        return root;
    }
}
