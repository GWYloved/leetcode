package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted as a binary number (from most-significant-bit to least-significant-bit.)

Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.

Example 1:

Input: [0,1,1]
Output: [true,false,false]
Explanation:
The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.  Only the first number is divisible by 5, so answer[0] is true.
Example 2:

Input: [1,1,1]
Output: [false,false,false]
Example 3:

Input: [0,1,1,1,1,1]
Output: [true,false,false,false,true,false]
Example 4:

Input: [1,1,1,0,1]
Output: [false,false,false,false,false]


Note:

1 <= A.length <= 30000
A[i] is 0 or 1
 */
public class array_1018_binary_prefix_divisible_by_5 {
    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        int reminder = 0;
        for (int i : A){
            if (i == 1){
                reminder = (reminder *2 + 1)%5;
            }
            if (i == 0){
                reminder = (reminder * 2) % 5;
            }
            result.add(reminder % 5 == 0);
        }
        return result;
    }

    public static void main(String[] args) {
        int i = 1;
        System.out.println(prefixesDivBy5(new int[]{0,1,1}));
        System.out.println(prefixesDivBy5(new int[]{1,1,1}));
        System.out.println(prefixesDivBy5(new int[]{0,1,1,1,1,1}));
        System.out.println(prefixesDivBy5(new int[]{1,1,1,0,1}));
        System.out.println(prefixesDivBy5(new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1}));
        System.out.println(prefixesDivBy5(new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1}));
        System.out.println(prefixesDivBy5(new int[]{0,0,1,0,1,1,1,1,1,0,0,1,0,0,0,1,1,0,0,1,0,0,0,0,1,0,1,1,0,0,0,1,0,1,0,0,0,0,1,0,1,1,1,1,0,1,0,1,1}));
        System.out.println(Arrays.toString("true,true,false,false,true,false,false,false,true,true,true,false,false,false,false,false,true,true,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false".split(",")));
        System.out.println(0b100101001011111111110000101000011111L);
    }

    /**
     * 思路：取合适的范围的数是个问题思路可以转化为一直保留对5取余的数，这个思路避免了过大整型溢出的问题
     * 相比较我之前一直右移一位差别很大。
     */
}
