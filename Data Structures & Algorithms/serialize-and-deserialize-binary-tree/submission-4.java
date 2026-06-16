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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder strBuilder = new StringBuilder();
        recSer(root, strBuilder);
        return strBuilder.toString();
    }

    private void recSer(TreeNode curr, StringBuilder strBuilder) {
        if (curr == null) {
            strBuilder.append("n,");
        } else {
            strBuilder.append(String.valueOf(curr.val) + ",");
            recSer(curr.left, strBuilder);
            recSer(curr.right, strBuilder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] i = new int[1];
        String[] elements = data.split(",");
        return recDes(i, elements);
    }

    private TreeNode recDes(int[] i, String[] elements) {
        String currStr = elements[i[0]++];
        if (currStr.equals("n")) return null;
        TreeNode curr = new TreeNode(Integer.parseInt(currStr));
        curr.left = recDes(i, elements);
        curr.right = recDes(i, elements);
        return curr;
    }
}
