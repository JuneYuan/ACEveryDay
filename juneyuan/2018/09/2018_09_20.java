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
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null)   return null;
        
        TreeNode lNode = lowestCommonAncestor(root.left, A, B);
        TreeNode rNode = lowestCommonAncestor(root.right, A, B);
        
        // root is LCA of A and B
        if (lNode != null && rNode != null) {
            return root;
        }
        // root node is A/B (including the case below)
        if (root == A || root == B) {
            return root;
        }
        // return lNode/rNode is root is not LCA
        return (lNode != null) ? lNode : rNode;
    }
}
