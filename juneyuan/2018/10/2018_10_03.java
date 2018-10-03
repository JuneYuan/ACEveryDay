/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (node == null)   return root;
        if (root == null)   return node;
        
        TreeNode rootCp = root;
        while (root != null) {
            if (node.val <= root.val && root.left == null) {
                root.left = node;
                break;
            } else if (node.val > root.val && root.right == null) {
                root.right = node;
                break;
            } else if (node.val <= root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        return rootCp;
    }
}
