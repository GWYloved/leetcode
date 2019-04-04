package array;

import java.util.Arrays;

/*
We have an array A of integers, and an array queries of queries.

For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the answer to the i-th query is the sum of the even values of A.

(Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)

Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.



Example 1:

Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
Output: [8,6,2,4]
Explanation:
At the beginning, the array is [1,2,3,4].
After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.


Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
1 <= queries.length <= 10000
-10000 <= queries[i][0] <= 10000
0 <= queries[i][1] < A.length
 */
public class array_985_sum_of_even_numbers_after_queries {
    public static int[] sumEvenAfterQueries1(int[] A, int[][] queries) {
        int height = queries.length;
        int[] temp = new int[A.length];
        int flag = 0;
        for (int i = 0; i < height; i++) {
            A[queries[i][1]] += queries[i][0];
            int sum = 0;
            for (int j : A) {
                if (j % 2 == 0) {
                    sum += j;
                }
            }
            temp[flag++] = sum;
        }
        return temp;
    }

    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int height = queries.length;
        int[] temp = new int[A.length];
        int evenSum = 0, flag = 0;
        for (int i : A) {
            if (i % 2 == 0) {
                evenSum += i;
            }
        }
        for (int i = 0; i < height; i++) {
            int position = queries[i][1];
            int t = queries[i][0];
            if (A[position] % 2 == 0) {
                if ((A[position] + t) % 2 == 0) {
                    evenSum += t;
                } else {
                    evenSum -= A[position];
                }
            } else if ((A[position] + t) % 2 == 0) {
                evenSum += A[position] + t;
            }
            temp[flag++] = evenSum;
            A[position] += t;
        }
        return temp;
    }

    public static void main(String[] args) {
        int[][] t = new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        System.out.println(Arrays.toString(sumEvenAfterQueries(new int[]{1, 2, 3, 4}, t)));
    }

    /**
     * 思路：第一个方法比较蠢，需要N*M的效率，之后使用类似于标志位的思想，就可以不用遍历，而是直接通过判断该位置是否是偶数
     * 以及结果是否是偶数来进行处理
     */
}
