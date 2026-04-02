package Tree.bst;

import Tree.TreeNode;

public class P230 {
    int[] res;
    int index = 0;

    public int kthSmallest(TreeNode root, int k) {
        res = new int[k];
        kthSmallest(root);
        return res[k - 1];
    }

    private void kthSmallest(TreeNode node) {
        if (node == null) return;
        if (index == res.length) return;
        kthSmallest(node.left);
        if(index < res.length) {
            res[index] = node.val;
            index++;
        }
        kthSmallest(node.right);
    }
}
