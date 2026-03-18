package Tree;

public class P104 {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return level(root, 0);
    }

    private int level(TreeNode node, int level){
        if(node == null) return level;
        return Math.max(level(node.left, level+1), level(node.right, level+1));
    }



    private int bottomUp(TreeNode node){
        if(node != null)
            return Math.max(bottomUp(node.left)+1, bottomUp(node.right)+1);
        return 0;
    }
}
