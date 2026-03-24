package Tree;

public class P124 {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        gainPath(root);
        return max;
    }

    public int gainPath(TreeNode root) {
        if (root == null) return 0;
        int l = Math.max(gainPath(root.left), 0);
        int r = Math.max(gainPath(root.right),0);
        int c = root.val;

        max = Math.max(max, c + l + r);
        return c + Math.max(l,r);
    }


}
