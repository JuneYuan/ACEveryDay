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
    Deque<TreeNode> stack = new ArrayDeque<>();
    Deque<TreeNode> pathA, pathB;
    
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        
        helper(root, A, B);
        
        TreeNode result = null;
        while (!pathA.isEmpty() && !pathB.isEmpty() && pathA.peek().equals(pathB.peek())) {
            result = pathA.poll();
            pathB.poll();
        }
        
        return result;
    }
    
    private void helper(TreeNode root, TreeNode A, TreeNode B) {
        stack.push(root);
        
        if (root == A) {
            pathA = cpPath(stack);
        }
        if (root == B) {
            pathB = cpPath(stack);
        }
        
        if (root.left != null) {
            helper(root.left, A, B);
        }
        
        if (root.right != null) {
            helper(root.right, A, B);
        }
        
        stack.pop();
    }
    
    private Deque<TreeNode> cpPath(Deque<TreeNode> stack) {
        Deque<TreeNode> route = new ArrayDeque<>();
        
        Iterator<TreeNode> it = stack.iterator();
        while (it.hasNext()) {
            route.push(it.next());
        }
        
        return route;
    }
    
}
