package Tree;

public class P543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int diameter = height(root.left) + height(root.right);
        return Math.max(Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)), diameter);
    }

    private int height(TreeNode root){
        if(root == null) return 0;
        return Math.max((height(root.left) + 1), height(root.right)+ 1);
    }


}
