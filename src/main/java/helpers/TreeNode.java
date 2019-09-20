package helpers;

public class TreeNode implements Comparable<TreeNode>{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }

    @Override
    public int compareTo(TreeNode o) {
        return Integer.compare(this.val, o.val);
    }
}
