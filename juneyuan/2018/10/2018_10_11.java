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
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> ret = new ArrayList<>();
        helper(root, k1, k2, ret);
        return ret;
    }
    
    private void helper(TreeNode root, int k1, int k2, List<Integer> ret) {
        if (root == null)   return;

        if (root.left != null && root.val >= k1) {
            helper(root.left, k1, k2, ret);
        }
            
        if (k1 <= root.val && root.val <= k2) {
            ret.add(root.val);
        }
            
        if (root.right != null && root.val <= k2) {
            helper(root.right, k1, k2, ret);
        }
    }
}
