package Tree.bst;

import Tree.TreeNode;

public class P98 {


    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!allSubtreeLess(root.left, root.val)) return false;
        if (!allSubtreeMore(root.right, root.val)) return false;
        if (!isValidBST(root.left)) return false;
        return isValidBST(root.right);
    }

    private boolean allSubtreeLess(TreeNode node, int val) {
        if (node == null) return true;
        System.out.println("val: "+val +" node: "+ node.val);
        if (node.val >= val) return false;
        if (!allSubtreeLess(node.left, val)) return false;
        return allSubtreeLess(node.right, val);
    }

    private boolean allSubtreeMore(TreeNode node, int val) {
        if (node == null) return true;
        System.out.println("val: "+val +" node: "+ node.val);
        if (node.val <= val) return false;
        if (!allSubtreeMore(node.left, val)) return false;
        return allSubtreeMore(node.right, val);
    }



    //Sol O(n)
    public boolean isValidBSTUsingPreviousNode(TreeNode root) {
        if (root == null) return true;
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode node, Integer min, Integer max){

        if(node == null) return true;
        if(min != null && min >= node.val) return false;
        if(max != null && max <= node.val) return false;

        return isValid(node.left,min ,node.val) && isValid(node.right, node.val, max);

    }








}
