package Tree;

public class P226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        TreeNode copy = root.left;
        root.left = root.right;
        root.right = copy;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
