package Tree;

import java.util.*;

/*
107. Binary Tree Level Order Traversal II
Easy

1215

205

Add to List

Share
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/
public class LC107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(root == null) {
            return output;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<TreeNode> temp = new ArrayList<TreeNode>();
            while(!queue.isEmpty()) {
                temp.add(queue.poll());
            }
            List<Integer> tempValues = new ArrayList<Integer>();
            for(TreeNode value: temp) {
                if (value.left != null) queue.add(value.left);
                if (value.right != null) queue.add(value.right);
                tempValues.add(value.val);
            }
            output.add(tempValues);
        }
        Collections.reverse(output);
        return output;
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