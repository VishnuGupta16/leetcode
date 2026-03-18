package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P94 {
    //Given the root of a binary tree, return the inorder traversal of its nodes' values.
    //Left -> Root -> Right

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    public List<Integer> inorderTraversalUsingIteration(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(!stack.empty() || curr != null){
            //Push all left
            while (curr != null){
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
