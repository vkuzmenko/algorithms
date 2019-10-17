import helpers.TreeNode;

import java.util.*;

/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return res;
        queue.add(root);

        boolean isLevelEven = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> l = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                l.add(n.val);

                if (n.left != null)
                    queue.add(n.left);
                if (n.right != null)
                    queue.add(n.right);
            }

            if (isLevelEven) {
                Collections.reverse(l);
            }

            isLevelEven = !isLevelEven;
            res.add(l);
        }

        return res;
    }
}
