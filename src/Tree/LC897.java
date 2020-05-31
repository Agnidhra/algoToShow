package Tree;

/*
897. Increasing Order Search Tree

Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9


Constraints:

The number of nodes in the given tree will be between 1 and 100.
Each node will have a unique integer value from 0 to 1000.
*/
import java.util.LinkedList;
import java.util.Queue;

public class LC897 {
    Queue<Integer> queue;
    public TreeNode increasingBST(TreeNode root) {
        queue = new LinkedList<Integer>();
        preOrder(root, queue);
        TreeNode head = null, temp = null;
        while(!queue.isEmpty()) {
            if(head == null) {
                head = new TreeNode(queue.poll());
                temp = head;
            } else {
                temp.right = new TreeNode(queue.poll());
                temp = temp.right;
            }
        }
        return head;
    }

    public void preOrder(TreeNode root, Queue<Integer> queue) {
        if(root == null) {
            return;
        }
        preOrder(root.left, queue);
        queue.add(root.val);
        preOrder(root.right, queue);
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