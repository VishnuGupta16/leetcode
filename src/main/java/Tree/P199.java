package Tree;

import java.util.*;

public class P199 {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, List<TreeNode>> levelMap = new HashMap<>();
        levelOrder(root, 0, levelMap);
        List<Integer> res = new LinkedList<>();
        for(int i = 0; i < levelMap.size(); i++){
            res.add(levelMap.get(i).get(0).val);
        }
        return res;
    }

   private void levelOrder(TreeNode node, int level, Map<Integer, List<TreeNode>> levelMap){
        if(node == null) return;
        if(!levelMap.containsKey(level)) {
            levelMap.put(level, new LinkedList<>());
        }
        levelMap.get(level).add(node);
        levelOrder(node.right, level+1, levelMap);
       levelOrder(node.left, level+1, levelMap);
   }

    public List<Integer> rightSideViewUsingIteration(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> res = new LinkedList<>();
        while(!queue.isEmpty()){
            int level = queue.size();
            res.add(queue.peek().val);
            while(level > 0) {
                TreeNode n = queue.poll();
                if(n.right != null) queue.offer(n.right);
                if(n.left != null) queue.offer(n.left);
                level--;
            }
        }
        return res;
    }


}
