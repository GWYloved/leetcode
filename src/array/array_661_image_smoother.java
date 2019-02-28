package array;

/*
Given a 2D integer matrix M representing the gray scale of an image,
you need to design a smoother to make
the gray scale of each cell becomes
the average gray scale (rounding down) of
all the 8 surrounding cells and itself.
If a cell has less than 8 surrounding cells, then use as many as you can.

Example 1:
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
Note:
The value in the given matrix is in the range of [0, 255].
The length and width of the given matrix are in the range of [1, 150].
 */
class array_661_image_smoother {
    public static int[][] imageSmoother(int[][] M) {
        final int width = M[0].length;
        final int height = M.length;
        final int[][] result = new int[height][width];
        for (int index_Y = 0; index_Y < height; index_Y++) {
            final int[] temp = new int[width];
            for (int index_X = 0; index_X < width; index_X++) {
                final int left = Math.max(0, index_X - 1);
                final int right = Math.min(width - 1, index_X + 1);
                final int top = Math.max(0, index_Y - 1);
                final int bottom = Math.min(height - 1, index_Y + 1);
                final int temp_width = right - left + 1;
                final int temp_height = bottom - top + 1;
                int sum = 0;
                for (int i = left; i < right + 1; i++) {
                    for (int j = top; j < bottom + 1; j++) {
                        sum += M[j][i];
                    }
                }
                final int t = sum / (temp_height * temp_width);
                temp[index_X] = t;
            }
            result[index_Y] = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        imageSmoother(new int[][]{
                new int[]{2, 3, 4}, new int[]{5, 6, 7}, new int[]{8, 9, 10}, new int[]{11, 12, 13}, new int[]{14, 15, 16}});
    }

    /**
     * 解题思路：这题是我见过最无聊的
     */
}