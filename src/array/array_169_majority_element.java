package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 */
class array_169_majority_element {
    public static int majorityElement(int[] nums) {
        if (nums.length <= 1){
            return nums[0];
        }
        Arrays.sort(nums);
        int former,last;
        if (nums[0] == nums[1]){
            former = 1; last = 1;
        }else {
            former = 1; last = 0;
        }
        int flag = nums[0];
        int big = nums[0];
        for (int i = 1; i < nums.length; i ++){
            if (flag == nums[i]){
                last++;
                if (last > former){
                    big = nums[i];
                    former = last;
                }
                if (last > nums.length /2){
                    return big;
                }
            }else {
                flag = nums[i];
                last = 1;
            }
        }
        return big;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{6,5,5}));
    }

    /**
     * 思路：这题主要是计算最大的数字的数量，先排序，在遍历，这样时间复杂度最多为O(nlogn)，不过有个更好的方法
     * 最佳实践：
     * 直接一遍遍历，有一个数字做标记位，存储一个数，当当前这个数和存储的数相等时，标记位加1，否则减1，
     * 当标记位为0的时候，替换存储数，最后存储数就是最大的数。
     * 核心思想在于，有一个不同的，之前存的最大的数就应该减少一个，但是题目说必有一个数量大于N/2，所以就肯定会有一个数字的数量
     * 减去其余所有数字的数量结果仍然比0大的。
     * 这个方法有点取巧，如果是N/3的话，那就不行了。那就得老老实实排序之后处理了。
     */

    public static int majorityElement1(int[] nums) {
        int flag = 0;
        int can = nums[0];
        for (int i : nums){
            if (flag == 0){
                can = i;
            }
            if (can == i){
                flag ++;
            }else {
                flag --;
            }
        }
        return can;
    }
}
