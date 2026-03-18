package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P144 {

    //Given the root of a binary tree, return the preorder traversal of its nodes' values.
    //root -> left -> right
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        if (root == null) return res;
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }

    public List<Integer> preorderTraversalUsingForLoop(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        if(root != null)
            stack.add(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right != null) stack.add(node.right);
            if(node.left != null) stack.add(node.left);
        }

        return res;
    }
}
