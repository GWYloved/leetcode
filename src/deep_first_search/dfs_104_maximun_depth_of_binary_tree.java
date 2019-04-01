package deep_first_search;
/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 */

import normal_struct.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class dfs_104_maximun_depth_of_binary_tree {
    public int maxDepth(TreeNode root) {
        int h1, h2;
        if (root == null){
            return 0;
        }else {
            h1 = maxDepth(root.right);
            h2 = maxDepth(root.left);
            return (h1 < h2) ? h2+1 : h1+1;
        }
    }
    /**
     * 思路：此题是计算二叉树高度，判断二叉树，递归是很好的解决方法，中间有个相当于动态规划的思想，如果当前
     * 左节点计算出的高度比右节点低，就取右节点的高度来进行递归
     */

    /**
     * 除此之外还有层级遍历求树的高度方式
     */
    int maxDepth2(TreeNode root){
        int front = -1, rear = -1;
        int last = 0,level = 0;
        TreeNode[] queue = new TreeNode[100000];
        if (root == null){
            return 0;
        }
        queue[++rear] = root;
        TreeNode p;
        while (front < rear){
            p = queue[++front];
            if (p.left != null){
                queue[++rear] = p.left;
            }
            if (p.right != null){
                queue[++rear] = p.right;
            }
            if (front == last){
                level ++;
                last = rear;
            }
        }
        return level;
    }
}
