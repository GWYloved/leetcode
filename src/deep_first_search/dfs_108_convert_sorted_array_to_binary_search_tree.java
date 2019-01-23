package deep_first_search;

import NormalStruct.TreeNode;
/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */
class dfs_108_convert_sorted_array_to_binary_search_tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length < 1){
            return null;
        }
        return buildBst(nums, 0, nums.length-1);
    }

    public TreeNode buildBst(int[] nums, int low, int high){
        if (low <= high){
            int mid = (low + high) /2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = buildBst(nums, low, mid -1);
            node.right = buildBst(nums, mid + 1, high);
            return node;
        }else {
            return null;
        }
    }

    /**
     * 解题思路：给定一个数组，扭转为一颗平衡二叉树，
     * 思路就是二分法，不断查找每一块的中间一个值，然后将其作为节点，同时将两边的中间值作为其左右节点
     */
}
