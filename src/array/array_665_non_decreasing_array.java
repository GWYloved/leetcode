package array;

/*
Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example 1:
Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
Note: The n belongs to [1, 10,000].
 */
class array_665_non_decreasing_array {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;                                                                    //the number of changes
        for (int i = 1; i < nums.length && cnt <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                cnt++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i])
                    nums[i - 1] = nums[i];                    //modify nums[i-1] of a priority
                else
                    nums[i] = nums[i - 1];                                                //have to modify nums[i]
            }
        }
        return cnt <= 1;
    }
    /**
     * 思路：怎么讲呢，这题其实难度没有那么难，但是开始的时候做的思路很混乱
     * 主要有个问题是如何判断将目前的改为之前一位，还是讲之前一位改为目前的
     */
}
