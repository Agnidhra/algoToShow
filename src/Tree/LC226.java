package Tree;

/*
226. Invert Binary Tree
Easy

3071

47

Add to List

Share
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
*/


public class LC226 {
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }

    public TreeNode invert(TreeNode root) {
        if(root == null) {
            return root;
        }
        if(root.left == null && root.right == null) {
            return root;
        } else if(root.left == null && root.right != null) {
            root.left = root.right;
            root.right = null;
        } else if (root.left != null && root.right == null) {
            root.right = root.left;
            root.left = null;
        } else {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
        invert(root.left);
        invert(root.right);
        return root;
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