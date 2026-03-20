package Tree;

public class P1448 {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    private int goodNodes(TreeNode node, int max) {
        if (node == null) return 0;
        int count = 0;
        if (node.val >= max) count++;
        count += goodNodes(node.left, Math.max(node.val, max));
        count += goodNodes(node.right, Math.max(node.val, max));
        return count;
    }
}
