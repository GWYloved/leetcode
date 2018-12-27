package dynamic_programming;

/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
class dp_53_maximum_subarray {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        int[][] p = new int[length][length];
        for (int i = 0;i < length; i ++){
            int sum = 0;
            for (int j = i; j >= 0; j --){
                sum += nums[j];
                if (max < sum){
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * 思路：以上是我处理的过程，但是我无法理解怎么写出O(n)的算法
     * 我使用了2个排序，尽可能的只计算一半的面积
     */
    /*
    最佳实践：基于动态规划的思想，可以实时在之前出现的最大值和目前值的和和目前值之间进行选择，大的会作为新的目前最大值
    动态的决定了当前的最大值，并且
     */
    public static int maxSubArray1(int[] nums){
        int maxFlag = nums[0];
        int maxNow = nums[0];
        for (int i = 0;i < nums.length; i ++){
            maxFlag = Math.max(maxFlag + nums[i], nums[i]);
            maxNow = Math.max(maxNow, maxFlag);
        }
        return maxNow;

    }
}
