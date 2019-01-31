package array;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 */

import java.util.Arrays;

class array_189_rotate_array {
    public static void rotate(int[] nums, int k) {
        if (nums.length < 1|| k <= 0){
            return;
        }
        k = k % nums.length;
        while (k > 0){
            reorder(nums);
            k -- ;
        }
    }

    public static void reorder(int[] nums){
        int temp = nums[nums.length-1];
        for (int i = nums.length -2; i >= 0; i --){
            nums[i +1] = nums[i];
            nums[i] = temp;
            temp = nums[i];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7};
        rotate1(a, 3);
    }

    public static void rotate1(int[] nums, int k){
        if (nums.length < 1|| k <= 0){
            return;
        }
        k = k % nums.length;
        int[] temp = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < k; i ++){
            nums[i] = temp[nums.length - k + i];
        }
//        System.out.println(Arrays.toString(nums));
        for (int i = k; i < nums.length; i ++){
            nums[i] = temp[i - k];
        }
//        System.out.println(Arrays.toString(nums));
    }

    /**
     * 思路：这一题比较简单，难处在于如何使用O(1)的空间来实现一些快速的翻转操作
     * 我想了很久没有办法实现，事实上是可以实现的，这种局部翻转的思想值得学习
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
