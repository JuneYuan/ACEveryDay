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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    // [-10,-3,0,5,9]
    private TreeNode helper(int[] nums, int lb, int ub) {
        // terminations
        if (lb > ub)    return null;
        if (lb == ub)   return new TreeNode(nums[lb]);
        
        // recurse
        int idx = lb + (ub - lb)/2;
        TreeNode node = new TreeNode(nums[idx]);
        node.left = helper(nums, lb, idx - 1);
        node.right = helper(nums, idx + 1, ub);
        return node;
    }
}
