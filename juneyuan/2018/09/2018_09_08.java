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
    public List<Integer> postorderTraversal(TreeNode root) {
         List<Integer> result = new ArrayList<>();
         Deque<TreeNode> stack = new ArrayDeque<>();

         if (root != null) {
             stack.push(root);
         }
         TreeNode prev = null;
         while (!stack.isEmpty()) {
             TreeNode curr = stack.peek();

             boolean noChild = (curr.left == null) && (curr.right == null);
             boolean childVisited = false;
             if (prev != null && (curr.left == prev || curr.right == prev)) {
                 childVisited = true;
             }

             if (noChild || childVisited) {
                 curr = stack.pop();
                 result.add(curr.val);
                 prev = curr;
             } else {
                 if (curr.right != null) {
                     stack.push(curr.right);
                 }
                 if (curr.left != null) {
                     stack.push(curr.left);
                 }
             }
         }

         return result;
    }
}
