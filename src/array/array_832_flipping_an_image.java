package array;
/*
Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

Example 1:

Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
Example 2:

Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Notes:

1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1
 */

import java.util.Arrays;

class array_832_flipping_an_image {
    public static int[][] flipAndInvertImage(int[][] A) {
        int size = A.length;
        for (int i = 0; i < size; i++) {
            int[] temp = Arrays.copyOf(A[i], A[i].length);
            for (int j = temp.length - 1; j >= 0; j--) {
                A[i][temp.length - 1 - j] = temp[j] == 1 ? 0 : 1;
            }
        }
        return A;
    }

    /**
     * 思路：java实现数组的翻转貌似必须要拷贝一次
     */
    public static void main(String[] args) {
        int[] temp = new int[]{1, 2};
        temp[0] = temp[1];
        System.out.println(Arrays.toString(temp));
    }
}
