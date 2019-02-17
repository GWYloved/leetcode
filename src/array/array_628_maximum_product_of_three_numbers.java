package array;

import java.util.Arrays;

/*
Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:

Input: [1,2,3]
Output: 6


Example 2:

Input: [1,2,3,4]
Output: 24


Note:

The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.

 */
public class array_628_maximum_product_of_three_numbers {
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[2],nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);
    }

    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{-1,-6,2,3,4}));
    }

    /**
     * 思路：这题只会有三种答案，一种是数量只有3个，直接返回三个的乘积，第二种是两个负数和一个正数的乘积，第三种是三个正数的乘积
     * 抽象出来就是对比01和末尾的乘积与末尾三位的乘积，哪个大返回哪个，这个方法也是我可以想出来的解法，原本准备用countingsort，
     * 但是给出的数组长度最大是104，countingsort的复杂度2001会超出104*log104，所以直接sort反而是比较好的。
     * 这题还有一种O(N)的解法，只需要求出最大的3个数和最小的2个数也可以算出结果,这种确认最大的几个值，确认最小的几个值的方式称为ONESCAN
     */

    public int maximumProduct2(int[] nums){
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, max1 = Integer.MIN_VALUE,
                max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int i: nums) {
            if (i <= min1) {
                min2 = min1;
                min1 = i;
            } else if (i <= min2) {     // n lies between min1 and min2
                min2 = i;
            }
            if (i >= max1) {            // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i >= max2) {     // n lies betweeen max1 and max2
                max3 = max2;
                max2 = i;
            } else if (i >= max3) {     // n lies betwen max2 and max3
                max3 = i;
            }
        }
        return Math.max(min1*min2*max1,max1*max2*max3);
    }

}
