package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
637. Average of Levels in Binary Tree
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
*/

public class LC637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> output = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<TreeNode> levelNodes = new ArrayList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            while(!queue.isEmpty()) {
                levelNodes.add(queue.poll());
            }
            Double sum = 0.0;
            for(TreeNode eachNode: levelNodes) {
                sum+=eachNode.val;
                if(eachNode.left != null) {
                    queue.add(eachNode.left);
                }
                if(eachNode.right != null) {
                    queue.add(eachNode.right);
                }
            }
            output.add(sum/levelNodes.size());
            levelNodes.removeAll(levelNodes);
        }
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