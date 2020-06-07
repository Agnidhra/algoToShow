package Tree;

import java.util.LinkedList;
import java.util.Queue;

/*
1302. Deepest Leaves Sum
Given a binary tree, return the sum of values of its deepest leaves.


Example 1:



Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15


Constraints:

The number of nodes in the tree is between 1 and 10^4.
The value of nodes is between 1 and 100.

*/
public class LC1302 {
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        int maxDepth = findMaxDepth(root);
        return sumOfDeepest(root, 1, maxDepth);
    }

    public int sumOfDeepest(TreeNode root, int currentLevel, int mustLevel) {
        if(currentLevel > mustLevel || root == null) {
            return 0;
        } else if(currentLevel == mustLevel) {
            sum += root.val;
        }else if (currentLevel< mustLevel) {
            currentLevel++;
            if(root.left != null) {
                sumOfDeepest(root.left, currentLevel, mustLevel);
            }
            if(root.right != null) {
                sumOfDeepest(root.right, currentLevel, mustLevel);
            }
        }
        return sum;
    }



    public int findMaxDepth(TreeNode T) {
        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(T);
        while(!queue.isEmpty()) {
            maxDepth++;
            LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
            while(!queue.isEmpty()) {
                nodes.add(queue.poll());
            }
            while(!nodes.isEmpty()) {
                TreeNode temp = nodes.removeFirst();
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return maxDepth;
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