package array;

/*
Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

Example 1:

Input:
nums = [1, 7, 3, 6, 5, 6]
Output: 3
Explanation:
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.


Example 2:

Input:
nums = [1, 2, 3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.


Note:

The length of nums will be in the range [0, 10000].
Each element nums[i] will be an integer in the range [-1000, 1000].
 */
class array_724_find_pivot_index {
    public int pivotIndex(int[] nums) {
        if (nums.length < 1) {
            return -1;
        }
        int totalSum = 0;
        for (int i : nums) {
            totalSum += i;
        }
        if (totalSum == nums[0]) {
            return 0;
        }
        int flagSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            flagSum += nums[i];
            totalSum -= nums[i];
            if (totalSum - nums[i + 1] == flagSum) {
                return i + 1;
            }
        }
        return -1;
    }
    /**
     * 解题思路：这一题是求平衡点，刚开始我觉得双指针前后挪动可以，但是后来发现可以有负数的。
     * 之后思路做了一个转变，就是先O(n)复杂度求个和，然后单指针挪动求前部分的和。
     * 不过又一个wrong answer，就是可以返回0，因为整个和加起来等于第0个，这样返回0就好了。
     */
}
