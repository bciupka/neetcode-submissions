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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preorderList = Arrays.stream(preorder).boxed().toList();
        List<Integer> inorderList = Arrays.stream(inorder).boxed().toList();
        return rec(preorderList, inorderList);
    }

    private TreeNode rec(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.size() == 0 || inorder.size() == 0) {
            return null;
        }

        
        TreeNode root = new TreeNode(preorder.get(0));
        int mid = inorder.indexOf(preorder.get(0));
        root.left = rec(preorder.subList(1, mid + 1), inorder.subList(0, mid));
        root.right = rec(preorder.subList(mid + 1, preorder.size()), inorder.subList(mid + 1, inorder.size()));

        return root;

    }
}
