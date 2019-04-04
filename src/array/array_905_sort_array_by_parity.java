package array;

import java.util.Arrays;

/*
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.



Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.


Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000

 */
public class array_905_sort_array_by_parity {
    public static int[] sortArrayByParity2(int[] A) {
        int[] temp1 = new int[A.length];
        int[] temp2 = new int[A.length];
        int flag_temp1 = -1;
        int flag_temp2 = -1;
        for (int i : A) {
            if (i % 2 == 0) {
                temp1[flag_temp1 + 1] = i;
                flag_temp1++;
            } else {
                temp2[flag_temp2 + 1] = i;
                flag_temp2++;
            }
        }
        for (int i = 0; i <= flag_temp1; i++) {
            A[i] = temp1[i];
        }
        for (int i = 0; i <= flag_temp2; i++) {
            A[i + flag_temp1 + 1] = temp2[i];
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{1, 3, 4, 4, 6, 3})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{1})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{0, 1})));
    }

    public static int[] sortArrayByParity(int[] A) {
        if (A.length == 1) {
            return A;
        }
        int start = 0;
        int end = A.length - 1;
        while (start < end && start < A.length - 1 && end > 0) {
            if (A[start] % 2 == 1 && A[end] % 2 == 0) {
                int temp = A[start];
                A[start] = A[end];
                A[end] = temp;
                start++;
                end--;
            }
            if (A[start] % 2 == 0) {
                start++;
            }
            if (A[end] % 2 == 1) {
                end--;
            }
        }
        return A;
    }

    /**
     * 思路：写了2个，空间复杂度比价高和O（1）的
     */
}
