import helpers.TreeNode;

import java.util.*;

/*
https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/
*/
public class BinaryTreeLevelOrderTraversal {
    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return res;
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> l = new ArrayList<>(size);

            for (int i = 0; i < size ; i++) {
                TreeNode n = queue.poll();
                l.add(n.val);

                if (n.left != null)
                    queue.add(n.left);
                if (n.right != null)
                    queue.add(n.right);
            }

            res.add(l);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
//        root.left.left = new TreeNode(3);
//        root.left.left.left = new TreeNode(5);
//        root.left.left.right = new TreeNode(6);
//        root.left.left.right.right = new TreeNode(7);
//        root.left.left.left.left = new TreeNode(4);

        List<List<Integer>> res = levelOrder(root);
    }
}
