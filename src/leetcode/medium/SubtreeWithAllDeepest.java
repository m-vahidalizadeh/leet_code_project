package leetcode.medium;

import java.util.*;

/**
 * 865. Smallest Subtree with all the Deepest Nodes
 * Given the root of a binary tree, the depth of each node is the shortest distance to the root.
 *
 * Return the smallest subtree such that it contains all the deepest nodes in the original tree.
 *
 * A node is called the deepest if it has the largest depth possible among any node in the entire tree.
 *
 * The subtree of a node is tree consisting of that node, plus the set of all descendants of that node.
 *
 * Note: This question is the same as 1123: https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4]
 * Output: [2,7,4]
 * Explanation: We return the node with value 2, colored in yellow in the diagram.
 * The nodes coloured in blue are the deepest nodes of the tree.
 * Notice that nodes 5, 3 and 2 contain the deepest nodes in the tree but node 2 is the smallest subtree among them, so we return it.
 * Example 2:
 *
 * Input: root = [1]
 * Output: [1]
 * Explanation: The root is the deepest node in the tree.
 * Example 3:
 *
 * Input: root = [0,1,3,null,2]
 * Output: [2]
 * Explanation: The deepest node in the tree is 2, the valid subtrees are the subtrees of nodes 2, 1 and 0 but the subtree of node 2 is the smallest.
 *
 * Constraints:
 *
 * The number of nodes in the tree will be in the range [1, 500].
 * 0 <= Node.val <= 500
 * The values of the nodes in the tree are unique.
 */
public class SubtreeWithAllDeepest {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Map<TreeNode, TreeNode> parents;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        parents = new HashMap<>();
        List<TreeNode> leaves = null;
        List<TreeNode> currLevel = new ArrayList<>();
        currLevel.add(root);
        while (!currLevel.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode node : currLevel) {
                if (node.left != null) {
                    parents.put(node.left, node);
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    parents.put(node.right, node);
                    nextLevel.add(node.right);
                }
            }
            if (nextLevel.isEmpty()) {
                leaves = currLevel;
            }
            currLevel = nextLevel;
        }
        TreeNode parent = leaves.get(0);
        for (int i = 1; i < leaves.size(); i++) {
            parent = findCommonAncestor(parent, leaves.get(i));
        }
        return parent;
    }

    private TreeNode findCommonAncestor(TreeNode a, TreeNode b) {
        Set<TreeNode> aParents = new HashSet<>();
        while (a != null) {
            aParents.add(a);
            a = parents.get(a);
        }
        while (b != null) {
            if (aParents.contains(b)) return b;
            b = parents.get(b);
        }
        return null;
    }

}
