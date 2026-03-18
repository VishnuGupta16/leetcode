package Tree;

import StringSearchAlgo.KMP;

import java.util.*;

public class P572 {

    //Below doesn't work r =[10,5,null,4] and s= [10,4,null,null,5]
//    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//
//        List<Integer> f = inOrder(root);
//        List<Integer> s = inOrder(subRoot);
//        if(s.size() > f.size()) return false;
//        int i = 0;
//        while (i < s.size()){
//            if(!Objects.equals(f.get(i), s.get(i))) break;
//            i++;
//        }
//        if(i == s.size()) return true;
//
//        i = f.size() - s.size();
//        while (i < f.size()){
//            if(!Objects.equals(f.get(i), s.get(i))) return false;
//            i++;
//        }
//
//        return true;
//
//    }
//
//    List<Integer> inOrder(TreeNode root){
//        List<Integer> res = new LinkedList<>();
//        if(root == null) return res;
//        res.addAll(inOrder(root.left));
//        res.add(root.val);
//        res.addAll(inOrder(root.right));
//        return res;
//    }

    //This works
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (isSub(root, subRoot)) return true;
        if (isSubtree(root.left, subRoot)) return true;
        return isSubtree(root.right, subRoot);
    }

    public boolean isSubtreeUsingMap(TreeNode root, TreeNode subRoot) {
        int level = height(subRoot, null);
        Map<Integer, List<TreeNode>> levelMap = new HashMap<>();
        int x = height(root, levelMap);
        if (level > x) return false;
        if (!levelMap.get(level).isEmpty()) {
            for (TreeNode node : levelMap.get(level)) {
                if (isSub(node, subRoot)) return true;
            }
        }
        return false;
    }

    private boolean isSub(TreeNode node, TreeNode subRoot) {
        if (node == null && subRoot == null) return true;
        if (node == null || subRoot == null) return false;
        if (node.val != subRoot.val) return false;
        if (!isSub(node.left, subRoot.left)) return false;
        return isSub(node.right, subRoot.right);
    }

    private int height(TreeNode treeNode, Map<Integer, List<TreeNode>> levelMap) {
        if (treeNode == null) {
            return 0;
        }
        int left = height(treeNode.left, levelMap) + 1;
        int right = height(treeNode.right, levelMap) + 1;

        if (levelMap != null) {
            if (!levelMap.containsKey(right)) {
                levelMap.put(right, new ArrayList<>());
            }
            levelMap.get(right).add(treeNode);

            if (!levelMap.containsKey(left)) {
                levelMap.put(left, new ArrayList<>());
            }
            levelMap.get(left).add(treeNode);
        }

        return Math.max(left, right);
    }

    public boolean isSubSerialization(TreeNode root, TreeNode subRoot){
        final String subSer = serializeTree(subRoot);
        final String rootSer = serializeTree(root);

        KMP kmp = new KMP();
        return kmp.regex(rootSer, subSer);
    }

    private String serializeTree(TreeNode node) {
        String res = "-";
        if (node == null) return res + "#";
        res += node.val;
        res += serializeTree(node.left);
        res += serializeTree(node.right);
        return res;
    }
}
