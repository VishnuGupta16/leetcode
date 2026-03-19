package Tree;

import java.util.Stack;

public class P236 {


    public TreeNode lowestCommonAncestorWithoutStack(TreeNode root, TreeNode p, TreeNode q) {
        // Base case
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search in left and right subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides are non-null → LCA found
        if (left != null && right != null) {
            return root;
        }

        // Return non-null side
        return (left != null) ? left : right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return travel(root, p, q, new Stack<>(), new Stack<>());
    }


    private TreeNode travel(TreeNode node, TreeNode p, TreeNode q, Stack<TreeNode> pVisitedNode, Stack<TreeNode> qVisitedNode) {
        if (node == null) return null;
        TreeNode left = travel(node.left, p, q, pVisitedNode, qVisitedNode);
        if (left != null) return left;
        TreeNode right = travel(node.right, p, q, pVisitedNode, qVisitedNode);
        if (right != null) return right;
        if (node.val == p.val) {
            pVisitedNode.push(node);
        } else if (node.val == q.val) {
            qVisitedNode.push(node);
        }
        if (!pVisitedNode.empty()) {
            TreeNode pLast = pVisitedNode.peek();
            if (node.left != null && node.left.val == pLast.val) {
                pVisitedNode.push(node);
            } else if (node.right != null && node.right.val == pLast.val) {
                pVisitedNode.push(node);
            }
        }
        if (!qVisitedNode.empty()) {
            TreeNode qLast = qVisitedNode.peek();
            if (node.left != null && node.left.val == qLast.val) {
                qVisitedNode.push(node);
            } else if (node.right != null && node.right.val == qLast.val) {
                qVisitedNode.push(node);
            }
        }
        if (!qVisitedNode.empty() && !pVisitedNode.empty()) {
            if (qVisitedNode.peek() == pVisitedNode.peek()) return qVisitedNode.peek();
        }
        return null;
    }
}
