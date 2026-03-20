package Tree;

import java.util.*;

class Node extends TreeNode {
    Node next;
}

public class P116 {
    public Node connect(Node root) {
        levelOrder(root, 0, new HashMap<>());
        return root;

    }

    public Node connectWithLevelOrder(Node root) {
        if(root == null) return root;
        if(root.left != null) ((Node)root.left).next = ((Node)root.right);
        if(root.right != null) ((Node)root.right).next = (Node) ((Node)root.next).left;
        connect((Node) root.left);
        connect((Node) root.right);
        return root;

    }



    private void levelOrder(Node node, int level, Map<Integer, Stack<Node>> levelMap) {
        if (node == null) return;
        if (!levelMap.containsKey(level)) {
            levelMap.put(level, new Stack<>());
        }
        if(!levelMap.get(level).isEmpty()){
            levelMap.get(level).peek().next = node;
        }
        levelMap.get(level).push(node);
        levelOrder((Node) node.left, level + 1, levelMap);
        levelOrder((Node) node.right, level + 1, levelMap);

    }



}
