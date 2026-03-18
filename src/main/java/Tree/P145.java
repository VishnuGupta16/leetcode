package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P145 {

    //Given the root of a binary tree, return the postorder traversal of its nodes' values.
    //left -> right -> root
    //Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
    //Output: [4,6,7,5,2,9,8,3,1]

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        if(root == null) return res;
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);


        return res;
    }

    public List<Integer> postorderTraversalUsingTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Stack<TreeNode> stack2 = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.add(root);
        while(!stack1.empty() ){
          stack2.add(stack1.pop());
          if(stack2.peek().left != null) stack1.push(stack2.peek().left);
          if(stack2.peek().right != null) stack1.push(stack2.peek().right);
        }

        while(!stack2.empty()){
            res.add(stack2.pop().val);
        }
        return res;
    }

    public List<Integer> postorderTraversalUsingTraversalUsingSingleStack(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        TreeNode curr = root;
        Stack<TreeNode> stack1 = new Stack<>();
        TreeNode lastVisitedNode = null;

        while(!stack1.empty() || curr != null ){
            //Go to left most
            while (curr != null){
                stack1.add(curr);
                curr = curr.left;
            }

            if(stack1.peek().right == null || stack1.peek().right == lastVisitedNode){
                lastVisitedNode = stack1.pop();
                res.add(lastVisitedNode.val);
            } else {
                curr = stack1.peek().right;
            }
        }


        return res;
    }



}
