package Tree;

public class P110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(height(root.left) - height(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);

    }


    private int height(TreeNode root){
        if(root == null) return 0;

        return Math.max(height(root.left) + 1 , height(root.right) + 1);
    }
}
