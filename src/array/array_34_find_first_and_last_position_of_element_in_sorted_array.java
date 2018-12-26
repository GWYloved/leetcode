package array;

/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */
class array_34_find_first_and_last_position_of_element_in_sorted_array {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length < 1){
            return new int[]{-1,-1};
        }
        int low = 0;
        int high = nums.length - 1;
        int start = -1;
        int end = -1;
        while (low <= high && low < nums.length && high < nums.length){
            int middle = (low + high) >> 1;
            if (nums[middle] == target){
                start = middle;
                end = middle;
            }
        }
    }
}
