package Tree;

public class P112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(targetSum == root.val && root.left == null && root.right == null) return true;
        if(hasPathSum(root.left, targetSum - root.val)) return true;
        if(hasPathSum(root.right, targetSum - root.val)) return true;
        return false;
    }



}
