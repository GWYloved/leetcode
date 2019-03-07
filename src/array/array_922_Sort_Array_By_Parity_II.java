package array;

import java.util.Arrays;

/*
Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

You may return any answer array that satisfies this condition.



Example 1:

Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.


Note:

2 <= A.length <= 20000
A.length % 2 == 0
0 <= A[i] <= 1000
 */
@SuppressWarnings("Duplicates")
public class array_922_Sort_Array_By_Parity_II {
    public static int[] sortArrayByParityII1(int[] A) {
        int[] temp1 = new int[A.length];
        int[] temp2 = new int[A.length];
        int flag1 = -1,flag2 = -1;
        for (int i : A){
            if (i % 2 == 0){
                temp1[flag1 + 1] = i;
                flag1 ++;
            }else {
                temp2[flag2 + 1] = i;
                flag2 ++;
            }
        }
        for (int i = 0; i <= flag1; i ++){
            A[2*i] = temp1[i];
        }
        for (int i = 0; i <= flag2; i++){
            A[2*i + 1] = temp2[i];
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{2,4,3,7})));
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{2,1})));
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{2,1,4,3,6,5})));
    }

    public static int[] sortArrayByParityII(int[] A) {
        int start = 0;//even
        int end = A.length -1;//odd
        while (start < A.length -1 && end > 0){
            if (A[start] % 2 == 1 && A[end] % 2 == 0){
                int temp = A[start];
                A[start] = A[end];
                A[end] =temp;
            }
            if (A[start] % 2 == 0){
                start += 2;
            }
            if (A[end] % 2 == 1){
                end -= 2;
            }
        }
        return A;
    }
    /**
     * 解题思路：同之前那题，有一点小变化而已
     */
}
