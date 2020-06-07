package Tree;

import java.util.ArrayList;
import java.util.List;

/*
530. Minimum Absolute Difference in BST
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).


Note:

There are at least two nodes in this BST.
*/
public class LC530 {
    List<Integer> nodes;
    public int getMinimumDifference(TreeNode root) {
        nodes = new ArrayList<Integer>();
        int difference = Integer.MAX_VALUE;
        inorder(root);
        for(int i =0;i<nodes.size()-1; i++) {
            if((nodes.get(i+1) - nodes.get(i)) < difference){
                difference = nodes.get(i+1) - nodes.get(i);
            }
        }
        return difference;
    }
    public void inorder(TreeNode root){
        if(root == null) {
            return;
        }
        inorder(root.left);
        nodes.add(root.val);
        inorder(root.right);
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