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
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return "";
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (curr == null) {
                    strBuilder.append("n,");
                    continue;
                }

                queue.offer(curr.left);
                queue.offer(curr.right);
                strBuilder.append(String.valueOf(curr.val) + ",");
            }
        }

        // System.out.println(strBuilder.toString());

        return strBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;

        String[] elements = data.split(",");
        TreeNode[] nodes = Arrays.stream(elements)
            .map(e -> e.equals("n") ? null : new TreeNode(Integer.parseInt(e)))
            .toArray(TreeNode[]::new);

        int p1 = 0;
        int p2 = 1;

        while (p2 < nodes.length) {
            TreeNode curr = nodes[p1++];
            if (curr == null) {
                continue;
            }

            curr.left = nodes[p2++];
            curr.right = nodes[p2++];
        }

        return nodes[0];
    }
}
