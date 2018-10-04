/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)   return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, long lb, long ub) {
        if (root == null)   return true;
        if (root.val <= lb || root.val >= ub)   return false;
        
        return helper(root.left, lb, root.val) && helper(root.right, root.val, ub);
    }
}
