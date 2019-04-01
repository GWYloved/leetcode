package deep_first_search;

import normal_struct.TreeNode;

/*
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
 */
class dfs_100_same_tree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        } else if(p == null || q == null){
            return false;
        }
        boolean isEqual = p.val == q.val;
        boolean isLeftEqual = isSameTree(p.left,q.left);
        boolean isRightEqual = isSameTree(p.right, q.right);
        return isEqual && isLeftEqual && isRightEqual;
    }
}
