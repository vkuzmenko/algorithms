import helpers.TreeNode;

public class BSTFromPreorder {

    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        if (preorder.length == 1) {
            return root;
        }

        for (int i = 1; i < preorder.length; ++i) {
            TreeNode current = root;
            int val = preorder[i];

            while (true) {
                if (val < current.val) {
                    if (current.left == null) {
                        current.left = new TreeNode(val);
                        break;
                    }
                    current = current.left;
                } else {
                    if (current.right == null) {
                        current.right = new TreeNode(val);
                        break;
                    }
                    current = current.right;
                }
            }
        }

        return root;
    }

    private static void preorderVisit(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + ",");
        preorderVisit(node.left);
        preorderVisit(node.right);
    }

    public static void main(String[] arg) {
        preorderVisit(bstFromPreorder(new int[]{8,5,1,7,10,12}));
    }
}
