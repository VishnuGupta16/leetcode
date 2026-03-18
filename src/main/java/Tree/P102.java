package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> l = new LinkedList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                l.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            res.add(l);
        }
        return res;
    }


    public List<List<Integer>> levelOrderUseRecursion(TreeNode root) {

        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root, 0, res);

        return res;
    }

    private void levelOrder(TreeNode node , int level, List<List<Integer>> res){
        if(node == null) return;

        if(res.size() <= level) {
            res.add(level, new LinkedList<>());
        }
        res.get(level).add(node.val);
        levelOrder(node.left, level+1, res);
        levelOrder(node.right, level+1, res);
    }




}
