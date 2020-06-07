package Tree;

/*
653. Two Sum IV - Input is a BST
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True


Example 2:

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
*/

import java.util.HashMap;

public class LC653 {
    HashMap<Integer, Integer> valCount;
    public boolean findTarget(TreeNode root, int k) {
        valCount = new HashMap<Integer, Integer>();
        inOrder(root);
        for(int value: valCount.keySet()){
            if(k-value == value) {
                if(valCount.get(value) > 1) {
                    return true;
                }
            } else {
                if(valCount.containsKey(k-value)) {
                    return true;
                }
            }
        }
        return false;
    }
    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        valCount.put(root.val, valCount.getOrDefault(root.val, 0)+1);
        inOrder(root.left);
        inOrder(root.right);
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