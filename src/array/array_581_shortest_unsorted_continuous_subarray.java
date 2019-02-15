package array;

import java.util.Arrays;

/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.
 */
class array_581_shortest_unsorted_continuous_subarray {
    public static int findUnsortedSubarray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int start = 0, end = nums.length - 1;
        boolean findStart = false, findEnd = false;
        while (start < nums.length) {
            if (temp[start] == nums[start]) {
                start++;
            } else {
                findStart = true;
                break;
            }
        }
        while (end > -1) {
            if (temp[end] == nums[end]) {
                end--;
            } else {
                findEnd = true;
                break;
            }
        }
        if (findEnd && findStart) {
            return end - start + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 2, 3, 3}));
    }

    /**
     * 思路：这题原本的想法是找到大小不对的地方，然后记录位置。但是是错误的，后来想想先排个序，然后对比差别就好了
     * 这个做法有个优化点，其实在排序的过程中差别就确定下来了，所以把排序扩写一下，那么两端可以在排序的时候确认下来
     * 这样可以节省空间申请和一个O（n）的复杂度
     * 最佳实践：这题是有最佳实践的，o(N)复杂度以及O(1)空间复杂度，思路还是很巧妙的
     */
    public int findUnsortedSubarray2(int[] nums) {
        int length = nums.length, begin = -1, end = -2, min = nums[length - 1], max = nums[0];
        for (int i = 1; i < length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[length - 1 - i]);
            if (nums[i] < max) end = i;
            if (nums[length - 1 - i] > min) begin = length - 1 - i;
        }
        return end - begin + 1;
    }
    /**
     * 最佳实践思路：
     */
}
