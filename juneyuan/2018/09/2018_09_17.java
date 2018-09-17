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
    public TreeNode invertTree(TreeNode root) {
        if (root == null)   return null;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int qSz = q.size();
            for (int i = 0; i < qSz; i++) {
                TreeNode node = q.poll();
                swapChildren(node);
                
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        
        return root;
    }
    
    private void swapChildren(TreeNode node) {
        if (node == null)   return;
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
    
}
