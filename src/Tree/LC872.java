package Tree;

import java.util.ArrayList;
import java.util.List;

/*
872. Leaf-Similar Trees
Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.



Constraints:

Both of the given trees will have between 1 and 200 nodes.
Both of the given trees will have values between 0 and 200
*/
public class LC872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafValues1 = new ArrayList<Integer>();
        List<Integer> leafValues2 = new ArrayList<Integer>();
        leafValues1 = getLeafNodeValues(root1, leafValues1);
        leafValues2 = getLeafNodeValues(root2, leafValues2);
        if(leafValues1.size() != leafValues2.size()){
            return false;
        }
        for(int i = 0; i< leafValues1.size(); i++) {
            if(leafValues1.get(i) != leafValues2.get(i)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getLeafNodeValues(TreeNode root, List<Integer> leafValues){
        if(root.left == null && root.right == null) {
            leafValues.add(root.val);
            return leafValues;
        }
        if(root.left != null) {
            getLeafNodeValues(root.left, leafValues);
        }
        if(root.right != null) {
            getLeafNodeValues(root.right, leafValues);
        }
        return leafValues;
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