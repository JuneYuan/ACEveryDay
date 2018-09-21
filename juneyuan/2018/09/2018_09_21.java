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
    List<Deque<TreeNode>> paths = new ArrayList<>();
    Set<TreeNode> visited = new HashSet<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        dfs(root);

        Deque<TreeNode> pathA = null, pathB = null;
        for (Deque<TreeNode> path : paths) {
            if (pathA == null && path.contains(A)) {
                pathA = path;
            }

            if (pathB == null && path.contains(B)) {
                pathB = path;
            }

            if (pathA != null && pathB != null) {
                break;
            }
        }

        TreeNode result = null;

        if (pathA.equals(pathB)) {
            while (!(result = pathA.peek()).equals(A) && !result.equals(B)) {
                pathA.poll();
            }
            return result;
        }

        TreeNode peekA, peekB;
        while ((peekA = pathA.peek()) != null && (peekB = pathB.peek()) != null && peekA.equals(peekB)) {
            result = pathA.poll();
            pathB.poll();
        }
        return result;
    }

    public void dfs(TreeNode root) {
        stack.push(root);

        // 8 5 1
        if (root.left != null) {
            dfs(root.left);
        } else if (root.right != null) {
            dfs(root.right);
        }

        // 快照一下当前路径：[8 5 1] [8 5 4 2] [8 5 4 3] [8 7 6]
        if (!stack.isEmpty()) {
            savePath(stack);
        } else {
            return;
        }

        // 叶子结点出栈
        TreeNode t = stack.poll();
        visited.add(t);

        //
        TreeNode peek = stack.peek();
        while (peek != null && (peek.right == null || visited.contains(peek.right))) {
            t = stack.poll();
            visited.add(t);
            peek = stack.peek();
        }

        // dfs(4) dfs(3)
        if (peek != null) {
            dfs(peek.right);
        }
    }

    private void savePath(Deque<TreeNode> stack) {
        Deque<TreeNode> onePath = new ArrayDeque<>();

        Iterator<TreeNode> it = stack.iterator();
        while (it.hasNext()) {
            onePath.push(it.next());
        }

        paths.add(onePath);
    }
}
