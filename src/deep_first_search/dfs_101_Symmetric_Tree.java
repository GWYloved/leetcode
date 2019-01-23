package deep_first_search;
/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
 */

import NormalStruct.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class dfs_101_Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
//        if (root == null){
//            return true;
//        }
//        if (root.left != null && root.right != null) {
//            return isSymmetric(root.right, root.left);
//        } else return root.left == null && root.right == null;
        if (root == null) return true;
        return isSymmetric(root.right, root.left);
    }

    public boolean isSymmetric(TreeNode right, TreeNode left) {
//        if (right.val != left.val) {
//            return false;
//        } else {
//            //右子树的左节点和左子树的右节点进行比较
//            if (right.left != null && left.right != null) {
//                //右子树的右节点和左子树的左节点进行比较
//                if (right.right != null && left.left != null) {
//                    return isSymmetric(right.left, left.right) && isSymmetric(right.right, left.left);
//                } else if (right.right == null && left.left == null) {
//                    return isSymmetric(right.left, left.right);
//                }
//            } else if (right.left == null && left.right == null) {
//                if (right.right != null && left.left != null) {
//                    return isSymmetric(right.right, left.left);
//                } else if (right.right == null && left.left == null) {
//                    return true;
//                }
//            }
//            return false;
//        }
        if (left == null && right == null) return true;
        //noinspection ConstantConditions
        if ((left == null) || (right == null) || (left.val != right.val)) return false;
        return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }

    /**
     * 解题思路:虚线划掉的是我写的，现在的是摘抄的别人的，别人的写法更加简洁，
     * 有一点思想比较重要，就是针对参数的判断，应当放在形参处理域中，而不应处理完在分发
     */
}
