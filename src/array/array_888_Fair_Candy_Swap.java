package array;

/*
Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.

Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)

Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.

If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.



Example 1:

Input: A = [1,1], B = [2,2]
Output: [1,2]
Example 2:

Input: A = [1,2], B = [2,3]
Output: [1,2]
Example 3:

Input: A = [2], B = [1,3]
Output: [2,3]
Example 4:

Input: A = [1,2,5], B = [2,4]
Output: [5,4]


Note:

1 <= A.length <= 10000
1 <= B.length <= 10000
1 <= A[i] <= 100000
1 <= B[i] <= 100000
It is guaranteed that Alice and Bob have different total amounts of candy.
It is guaranteed there exists an answer.
 */

import java.util.Arrays;

public class array_888_Fair_Candy_Swap {
    public static int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        for (int i : A){
            sumA += i;
        }
        for (int i : B){
            sumB += i;
        }
        if (A.length < B.length){
            Arrays.sort(B);
            for (int i : A){
                int j = (sumB - sumA)/2 + i;
                if (j > B[B.length - 1] || j < B[0]){
                    continue;
                }
                int start = 0;
                int end = B.length -1;
                while (start <= end && end >= 0 && start <= B.length - 1){
                    int mid = (start + end) /2;
                    if (B[mid] == j){
                        return new int[]{i,j};
                    }else if (B[mid] < j){
                        start = mid + 1;
                    }else {
                        end = mid - 1;
                    }
                }
            }
        }else {
            Arrays.sort(A);
            for (int i : B){
                int j = (sumA - sumB) / 2 + i;
                if (j > A[A.length - 1] || j < A[0]){
                    continue;
                }
                int start = 0;
                int end = A.length - 1;
                while (start <= end && start <= A.length - 1 && end >= 0){
                    int mid = (start + end) /2;
                    if (A[mid] == j){
                        return new int[]{j,i};
                    }else if (A[mid] < j){
                        start = mid + 1;
                    }else {
                        end = mid - 1;
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fairCandySwap(new int[]{1,2},new int[]{2,3})));
        System.out.println(Arrays.toString(fairCandySwap(new int[]{2},new int[]{1,3})));
        System.out.println(Arrays.toString(fairCandySwap(new int[]{1,2,5}, new int[]{2,4})));
    }

    /**
     * 思路：刚开始使用的双循环，遍历AB，确定有个i和j满足A - i + j == B + i - j,但是效率不好 beat 13%
     * 优化1：求AB的和，排序其中的一个，然后从未排序的之中遍历，此时已经确定了需要的值，之后二分查找已排序的数组 beat 80%
     * 优化2：排序只找长度短的排，这样排序的复杂度会小一点 beat 80%
     * 优化3：二分查找之前先确定是否在范围内， beat 98%
     */
}