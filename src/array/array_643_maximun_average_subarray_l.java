package array;

/*
Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

Example 1:

Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75


Note:

1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].

 */
class array_643_maximun_average_subarray_l {
    public double findMaxAverage(int[] nums, int k) {
        int start = 0;
        int end = k;
        int temp = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            temp += nums[i];
        }
        max = temp;
        while (end < nums.length) {
            temp = temp - nums[start];
            temp = temp + nums[end];
            start++;
            end++;
            max = Math.max(max, temp);
        }
        return (((double) max) / k);
    }

    /**
     * 思路：这种指针挪动的问题，被称为滑动窗口
     */
}
