package Tree;

/*
104. Maximum Depth of Binary Tree
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
*/

public class LC104DFS {
    private int maxDepth;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        computMaxDepth(root, 1);
        return maxDepth;
    }

    public void computMaxDepth(TreeNode root, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        if(root.left != null) {
            computMaxDepth(root.left, depth+1);
        }
        if(root.right != null) {
            computMaxDepth(root.right, depth+1);
        }
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */