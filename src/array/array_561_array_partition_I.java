package array;

import java.util.Arrays;

/*
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
 */
class array_561_array_partition_I {
    /**
     * 思路：没啥特别的，复杂度在排序这儿nlogn
     * 不过竟然有最佳实践
     */
    public static int arrayPairSum2(int[] nums) {
        int[] arr = new int[20001];
        int lim = 10000;
        for (int num : nums)
            arr[num + lim]++;
        int d = 0, sum = 0;
        for (int i = -10000; i <= 10000; i++) {
            if (arr[i + lim] == 0) continue;
            sum += (arr[i + lim] + 1 - d) / 2 * i;
            d = (arr[i + lim] - d) % 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(arrayPairSum2(new int[]{1, 4, 3, 2}));
    }

    public int arrayPairSum(int[] nums) {
        int n = nums.length / 2;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += nums[2 * i];
        }
        return count;
    }

}
