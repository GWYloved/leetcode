package array;

import java.util.Arrays;

/*
n MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:
Input:
nums =
[[1,2],
 [3,4]]
r = 1, c = 4
Output:
[[1,2,3,4]]
Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
Example 2:
Input:
nums =
[[1,2],
 [3,4]]
r = 2, c = 4
Output:
[[1,2],
 [3,4]]
Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
Note:
The height and width of the given matrix is in range [1, 100].
The given r and c are all positive.

 */
public class array_566_reshape_the_matrix {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length < 1) {
            return nums;
        }
        int oldLine = nums.length;
        int oldRow = nums[0].length;
        if (oldLine * oldRow != r * c) {
            return nums;
        }
        int flagLine = 0, flagRow = 0;
        int[][] result = new int[r][c];
        for (int[] num : nums) {
            for (int j = 0; j < oldRow; j++) {
                result[flagLine][flagRow++] = num[j];
                if (flagRow >= c) {
                    flagRow = 0;
                    flagLine++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result = matrixReshape(new int[][]{new int[]{1, 2}, new int[]{3, 4}}, 1, 4);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 思路：这题主要难度在于题目的理解，原本我以为是矩阵变换那种，结果就是一个将原有数组依次填入新的数组而已
     * 没什么难度，beat100%
     */
}
