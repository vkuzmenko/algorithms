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

        List<Integer> curLevelNodes = new LinkedList<>();
        int nullsOnLevel = 0;
        int nullsOnNextLevel = 0;
        int maxNodesOnLevel = 1;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if (cur.left != null) {
                queue.add(cur.left);
            } else {
                nullsOnNextLevel++;
            }

            if (cur.right != null) {
                queue.add(cur.right);
            } else {
                nullsOnNextLevel++;
            }

            curLevelNodes.add(cur.val);

            if (maxNodesOnLevel == curLevelNodes.size() + nullsOnLevel) {
                res.add(curLevelNodes);
                curLevelNodes = new LinkedList<>();
                maxNodesOnLevel *= 2;
                nullsOnLevel = nullsOnNextLevel;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(5);
        root.left.left.left.left = new TreeNode(4);

        List<List<Integer>> res = levelOrder(root);
    }
}
