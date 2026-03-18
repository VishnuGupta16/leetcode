package Tree;

import java.util.*;

public class P103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;

        Map<Integer, List<TreeNode>> levelNodeMap = nodeAtEachLevel(root, 0, new HashMap<>());

        for(int i = 0; i < levelNodeMap.size(); i++){
            List<Integer> v = new LinkedList<>();
            List<TreeNode> nodes = levelNodeMap.get(i);
            if(i%2 == 0) {
                for (TreeNode node : nodes) {
                    v.add(node.val);
                }
            } else {
                for(int j = nodes.size() - 1; j >= 0; j--){
                    v.add(nodes.get(j).val);
                }
            }
            res.add(v);
        }

        return res;


        //Sol without Map
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//        int level = 0;
//        while (!q.isEmpty()) {
//
//            int size = q.size();
//            int copy = size;
//            Integer[] a = new Integer[size];
//
//            while (size > 0) {
//                TreeNode node = q.poll();
//                if(level % 2 == 0){
//                    a[copy - size] = node.val;
//                } else {
//                    a[size -1] = node.val;
//                }
//                if(node.left != null) q.offer(node.left);
//                if(node.right != null) q.offer(node.right);
//                size--;
//            }
//            res.add(Arrays.asList(a));
//            level++;
//        }
//
//        return res;


    }

    private Map<Integer, List<TreeNode>> nodeAtEachLevel(TreeNode node, int level, Map<Integer, List<TreeNode>> levelNodeMap){
        if(node == null) return levelNodeMap;
        if(!levelNodeMap.containsKey(level)){
            levelNodeMap.put(level, new LinkedList<>());
        }
        levelNodeMap.get(level).add(node);
        nodeAtEachLevel(node.left, level+1, levelNodeMap);
        nodeAtEachLevel(node.right, level+1, levelNodeMap);
        return levelNodeMap;
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
        if(level % 2 == 0){
            res.get(level).add(node.val);
        } else{
            res.get(level).addFirst(node.val);
        }
        levelOrder(node.left, level+1, res);
        levelOrder(node.right, level+1, res);
    }

}
